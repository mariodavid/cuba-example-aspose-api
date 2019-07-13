package de.diedavids.cuba.ceaa.web.screens.customer;

import com.aspose.words.ApiException;
import com.aspose.words.api.WordsApi;
import com.aspose.words.model.requests.PutConvertDocumentRequest;
import com.haulmont.cuba.core.app.FileStorageService;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.ceaa.AsposeApiFactory;
import de.diedavids.cuba.ceaa.entity.Customer;
import org.apache.commons.io.FileUtils;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@UiController("ceaa_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {

    @Inject
    protected AsposeApiFactory asposeApiFactory;

    @Inject
    protected FileStorageService fileStorageService;
    @Inject
    protected Table<FileDescriptor> documentsTable;
    @Inject
    protected ExportDisplay exportDisplay;

    @Subscribe("documentsTable.convertToPdf")
    protected void onDocumentsTableConvertToPdf(Action.ActionPerformedEvent event) throws FileStorageException, IOException {


        FileDescriptor selectedWordDocument = documentsTable.getSingleSelected();

        try {
            displayPdf(
                    selectedWordDocument,
                    convertWordToPdf(selectedWordDocument)
            );
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    private void displayPdf(FileDescriptor selectedWordDocument, byte[] pdfBytes) {
        String filename = selectedWordDocument.getName().replace(".docx", ".pdf");
        exportDisplay.show(new ByteArrayDataProvider(pdfBytes), filename, ExportFormat.PDF);
    }

    private byte[] convertWordToPdf(FileDescriptor selectedWordDocument) throws ApiException, FileStorageException, IOException {
        WordsApi api = asposeApiFactory.createApi();

        File result = api.putConvertDocument(
                convertToPdfRequest(selectedWordDocument)
        );

        return Files.readAllBytes(result.toPath());
    }

    private PutConvertDocumentRequest convertToPdfRequest(FileDescriptor selectedWordDocument) throws FileStorageException, IOException {
        return new PutConvertDocumentRequest(
                    file(selectedWordDocument),
                    ExportFormat.PDF.getFileExt(),
                    null,
                    null,
                    null,
                    "fonts"
            );
    }

    private File file(FileDescriptor selectedWordDocument) throws FileStorageException, IOException {
        byte[] bytes = fileStorageService.loadFile(selectedWordDocument);
        File tempFile = File.createTempFile("temporary-word-file", "docx", null);
        FileUtils.writeByteArrayToFile(tempFile, bytes);

        return tempFile;
    }


}