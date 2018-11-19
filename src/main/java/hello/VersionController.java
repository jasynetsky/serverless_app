package hello;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import java.util.Map;
 
@Controller
public class VersionController {
 
    @Value("${application.name}")
    private String applicationName;
 
    @Value("${build.version}")
    private String buildVersion;
 
    @Value("${build.timestamp}")
    private String buildTimestamp;
 
    @Value("${app.encoding}")
    private String appEncoding;
 
    @Value("${app.java.version}")
    private String appJavaVersion;
 
 
 
    @RequestMapping(method = RequestMethod.GET, value = "/version", produces = { MediaType.APPLICATION_JSON_VALUE })
    public HttpEntity<Map<String, String>> version() {
 
        Map<String, String> propertiesMap = Maps.newHashMap();
        propertiesMap.put("buildVersion", buildVersion);
        propertiesMap.put("applicationName", applicationName);
        propertiesMap.put("buildTimestamp", buildTimestamp);
        propertiesMap.put("appEncoding", appEncoding);
        propertiesMap.put("appJavaVersion", appJavaVersion);
 
 
        return new ResponseEntity<>(propertiesMap, HttpStatus.OK);
    }
}