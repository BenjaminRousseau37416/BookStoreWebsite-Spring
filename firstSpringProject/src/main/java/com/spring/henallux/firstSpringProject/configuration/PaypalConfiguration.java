package com.spring.henallux.firstSpringProject.configuration;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.context.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaypalConfiguration
{

    @Bean
    public Map<String, String> paypalSdkConfig() {

        Map<String, String> configMap = new HashMap<>();
        String mode = "sandbox";
        configMap.put("mode", mode);
        return configMap;
    }

    @Bean
    public OAuthTokenCredential oAuthTokenCredential() {

        String clientId = "Aci2stHgglLvVik3GgpJpgU2GihdTNaViViQmlnxlI6EyvzoI2H-uYTYc17u5w-_43S1YnQftIMGrDSY";
        String clientSecret = "EJoEERPe-6dMpAguLmiW9xX--cW8kpClHTsQl5u-6Adg2V1PvN8WNmQUjXpaqz27_kVS2UMpYkql1Qxu";

        return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
    }

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
        context.setConfigurationMap(paypalSdkConfig());
        return context;
    }

}
