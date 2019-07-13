package de.diedavids.cuba.ceaa.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;

@Source(type = SourceType.DATABASE)
public interface AsposeConfig extends Config {

    @Property("aspose.api.baseUrl")
    String getAsposeBaseUrl();

    @Property("aspose.api.version")
    String getAsposeApiVersion();

    @Property("aspose.api.appSid")
    String getAsposeAppSid();


    @Property("aspose.api.appKey")
    String getAsposeAppKey();

}