package io.geilehner.storyblok.model.assets;

public class AssetUploadBody {
    private String filename;
    private String size;
    private String assetFolder;

    public AssetUploadBody(String filename, String size, String assetFolder) {
        this.filename = filename;
        this.size = size;
        this.assetFolder = assetFolder;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAssetFolder() {
        return assetFolder;
    }

    public void setAssetFolder(String assetFolder) {
        this.assetFolder = assetFolder;
    }
}
