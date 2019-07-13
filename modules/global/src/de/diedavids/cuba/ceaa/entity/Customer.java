package de.diedavids.cuba.ceaa.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "CEAA_CUSTOMER")
@Entity(name = "ceaa_Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = 5934109545578517080L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "FIRST_NAME")
    protected String firstName;

    @JoinTable(name = "CEAA_CUSTOMER_FILE_DESCRIPTOR_LINK",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FILE_DESCRIPTOR_ID"))
    @OnDelete(DeletePolicy.CASCADE)
    @ManyToMany
    protected List<FileDescriptor> documents;

    public List<FileDescriptor> getDocuments() {
        return documents;
    }

    public void setDocuments(List<FileDescriptor> documents) {
        this.documents = documents;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}