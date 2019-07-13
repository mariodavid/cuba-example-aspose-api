## CUBA example - converting DOCX to PDF with Aspose Cloud

This example shows how to integrate Aspose Words Cloud in order to generate a PDF file out of a
word document (docx) via its cloud API.

### What is the problem with DOCX to PDF

Basically the accuracy of the result. Dealing with images, tables layers, columns, shapes etc. oftentimes leads
to inaccurate results in the target PDF file depending on what technology is used for doing the conversion.

### CUBA Reports require a OpenOffice server

The reports engine from CUBA normally solves this inaccuracy problem by using an external OpenOffice server, that is
doing the transformation. The accuracy is quite good there, much better as just using alternatives like docx4j directly.

But having OpenOffice on a server running sometimes leads to problems. Communication between the two applications is
done via TCP sockets. Sometimes the connections are not cleaned up correctly. Also there is the potential problem,
that there are memory problems with Open / LibreOffice. Also the software has to be updated, it has to made sure
that the new version is really compatible with the used CUBA application etc.

So, bottom line: there are a lot of things to consider.

### Externalizing the PDF generation

An alternative is that CUBA reports is just for "docx template" --> "docx document" generation, but the "docx document" --> "PDF document"
is externalized to an cloud based API.

[Aspose Words Cloud API](https://github.com/aspose-words-cloud/aspose-words-cloud-java) is an cloud service, that allows
to programmatically generate PDF files out of a word document (among a lot of other things).

### Converting DOCX to PDF via Aspose

In this example it is shown on how to interact with the Aspose Cloud offering via its SDK.


### Results

The results can be found in the [example-files](https://github.com/mariodavid/cuba-example-aspose-api/tree/master/example-files) directory. The results are almost 100% identical (which really supriesed me).
I intentionally took a lot of examples with complex layouts & images in place.



![Overview](https://github.com/mariodavid/cuba-example-aspose-api/blob/master/img/overview.gif)


