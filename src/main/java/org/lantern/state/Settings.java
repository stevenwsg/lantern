package org.lantern.state;

import java.util.Collection;

import org.codehaus.jackson.map.annotate.JsonView;
import org.lantern.LanternConstants;
import org.lantern.Whitelist;
import org.lantern.state.Model.Persistent;
import org.lantern.state.Model.Run;

/**
 * Base Lantern settings.
 */
public class Settings {

    private String userId = "";
    
    private String lang = "";
    
    private boolean autoStart = true;

    private boolean autoReport = true;
    
    private Mode mode;
    
    private int proxyPort = LanternConstants.LANTERN_LOCALHOST_HTTP_PORT;
    
    private boolean systemProxy = true;
    
    private boolean proxyAllSites = false;
    
    private Whitelist whitelist = new Whitelist();
    
    public enum Mode {
        give,
        get
    }
    
    @JsonView({Run.class, Persistent.class})
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonView(Run.class)
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @JsonView({Run.class, Persistent.class})
    public boolean isAutoStart() {
        return autoStart;
    }

    public void setAutoStart(final boolean autoStart) {
        this.autoStart = autoStart;
    }

    @JsonView({Run.class, Persistent.class})
    public boolean isAutoReport() {
        return autoReport;
    }

    public void setAutoReport(final boolean autoReport) {
        this.autoReport = autoReport;
    }

    @JsonView({Run.class, Persistent.class})
    public Mode getMode() {
        return mode;
    }

    public void setMode(final Mode mode) {
        this.mode = mode;
    }

    @JsonView({Run.class, Persistent.class})
    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(final int proxyPort) {
        this.proxyPort = proxyPort;
    }

    @JsonView({Run.class, Persistent.class})
    public boolean isSystemProxy() {
        return systemProxy;
    }

    public void setSystemProxy(final boolean systemProxy) {
        this.systemProxy = systemProxy;
    }

    @JsonView({Run.class, Persistent.class})
    public boolean isProxyAllSites() {
        return proxyAllSites;
    }

    public void setProxyAllSites(final boolean proxyAllSites) {
        this.proxyAllSites = proxyAllSites;
    }

    @JsonView({Run.class})
    public Collection<String> getProxiedSites() {
        return whitelist.getEntriesAsStrings();
    }

    public void setProxiedSites(final String[] proxiedSites) {
        whitelist.setStringEntries(proxiedSites);
    }

    @JsonView({Persistent.class})
    public Whitelist getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(Whitelist whitelist) {
        this.whitelist = whitelist;
    }
}
