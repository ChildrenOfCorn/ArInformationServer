package com.github.childrenofcorn.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.childrenofcorn.data.model.UserInfo;
import freemarker.template.Configuration;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by grishberg on 15.04.17.
 */
@Getter
@Setter
@JsonIgnoreProperties({"templateConfiguration"})
public class ConfigContext {
    private Configuration templateConfiguration;
    private int port;
    private int lightPin;
    UserInfo[] users;
}

