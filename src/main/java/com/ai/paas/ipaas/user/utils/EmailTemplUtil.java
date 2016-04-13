package com.ai.paas.ipaas.user.utils;


import java.util.HashMap;
import java.util.Map;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;


/**
 * User: Haoyanhui
 * Date: 2015-09-18
 * 描述 : 邮件模板
 */
public class EmailTemplUtil {

    private static Map<String, Object> proMap = null;
    private static VelocityEngine velocityEngine = null;

    static {
        proMap = new HashMap<String, Object>();
        proMap.put("resource.loader", "class");
        proMap.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

    }
    public static VelocityEngine getVelocityEngineInstance() {
        if (null == velocityEngine) {
            synchronized (VelocityEngine.class) {
                if (null == velocityEngine) {
                    velocityEngine = new VelocityEngine();
                    for (Map.Entry<String, Object> entry : proMap.entrySet()) {
                        velocityEngine.setProperty(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        return velocityEngine;
    }
}
