package io.geilehner.storyblok.model.assets;

import com.google.gson.annotations.SerializedName;

public class Fields {
    private String key;
    private String acl;
    private String expires;
    @SerializedName("Cache-Control")
    private String cacheControl;
    @SerializedName("Content-Type")
    private String contentType;
    private String policy;
    @SerializedName("x-amz-credential")
    private String xAmzCredential;
    @SerializedName("x-amz-algorithm")
    private String xAmzAlgorithm;
    @SerializedName("x-amz-date")
    private String xAmzDate;
    @SerializedName("x-amz-signature")
    private String xAmzSignature;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAcl() {
        return acl;
    }

    public void setAcl(String acl) {
        this.acl = acl;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getxAmzCredential() {
        return xAmzCredential;
    }

    public void setxAmzCredential(String xAmzCredential) {
        this.xAmzCredential = xAmzCredential;
    }

    public String getxAmzAlgorithm() {
        return xAmzAlgorithm;
    }

    public void setxAmzAlgorithm(String xAmzAlgorithm) {
        this.xAmzAlgorithm = xAmzAlgorithm;
    }

    public String getxAmzDate() {
        return xAmzDate;
    }

    public void setxAmzDate(String xAmzDate) {
        this.xAmzDate = xAmzDate;
    }

    public String getxAmzSignature() {
        return xAmzSignature;
    }

    public void setxAmzSignature(String xAmzSignature) {
        this.xAmzSignature = xAmzSignature;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
