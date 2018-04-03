package com.first;

import org.springframework.core.NestedIOException;
import org.springframework.core.io.ContextResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author 周云龙
 * @date 2018/4/3 11:22
 */
public abstract class ContextResourceSon implements ContextResource {
    public ContextResourceSon() {
    }

    @Override
    public boolean exists() {
        try {
            return this.getFile().exists();
        } catch (IOException var4) {
            try {
                InputStream is = this.getInputStream();
                is.close();
                return true;
            } catch (Throwable var3) {
                return false;
            }
        }
    }
    @Override
    public boolean isReadable() {
        return true;
    }
    @Override
    public boolean isOpen() {
        return false;
    }
    @Override
    public URL getURL() throws IOException {
        throw new FileNotFoundException(this.getDescription() + " cannot be resolved to URL");
    }
    @Override
    public URI getURI() throws IOException {
        URL url = this.getURL();

        try {
            return ResourceUtils.toURI(url);
        } catch (URISyntaxException var3) {
            throw new NestedIOException("Invalid URI [" + url + "]", var3);
        }
    }
    @Override
    public File getFile() throws IOException {
        throw new FileNotFoundException(this.getDescription() + " cannot be resolved to absolute file path");
    }
    @Override
    public long contentLength() throws IOException {
        InputStream is = this.getInputStream();
        Assert.state(is != null, "Resource InputStream must not be null");

        try {
            long size = 0L;

            int read;
            for(byte[] buf = new byte[255]; (read = is.read(buf)) != -1; size += (long)read) {
                ;
            }

            long var6 = size;
            return var6;
        } finally {
            try {
                is.close();
            } catch (IOException var14) {
                ;
            }

        }
    }
    @Override
    public long lastModified() throws IOException {
        long lastModified = this.getFileForLastModifiedCheck().lastModified();
        if (lastModified == 0L) {
            throw new FileNotFoundException(this.getDescription() + " cannot be resolved in the file system for resolving its last-modified timestamp");
        } else {
            return lastModified;
        }
    }

    protected File getFileForLastModifiedCheck() throws IOException {
        return this.getFile();
    }
    @Override
    public Resource createRelative(String relativePath) throws IOException {
        throw new FileNotFoundException("Cannot create a relative resource for " + this.getDescription());
    }
    @Override
    public String getFilename() {
        return null;
    }
    @Override
    public String toString() {
        return this.getDescription();
    }
    @Override
    public boolean equals(Object obj) {
        return obj == this || obj instanceof Resource && ((Resource)obj).getDescription().equals(this.getDescription());
    }
    @Override
    public int hashCode() {
        return this.getDescription().hashCode();
    }
}
