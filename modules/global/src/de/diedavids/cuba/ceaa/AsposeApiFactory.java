package de.diedavids.cuba.ceaa;

import com.aspose.words.ApiClient;
import com.aspose.words.api.WordsApi;
import de.diedavids.cuba.ceaa.config.AsposeConfig;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component("ceaa_AsposeApiFactory")
public class AsposeApiFactory {

    @Inject
    private AsposeConfig config;

    public WordsApi createApi() {

        WordsApi wordsApi = new WordsApi(new ApiClient());
        ApiClient client = wordsApi.getApiClient();
        client.setBaseUrl(config.getAsposeBaseUrl())
                .setApiVersion(config.getAsposeApiVersion())
                .setAppKey(config.getAsposeAppKey())
                .setAppSid(config.getAsposeAppSid());

        return wordsApi;
    }


}
