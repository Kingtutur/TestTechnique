package dao;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service("fileLoader")
public class FileLoader implements ResourceLoaderAware{

    private String name;

    private ResourceLoader resourceLoader;

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource getResource(String file_name) throws IOException {
        Resource banner = resourceLoader.getResource(file_name);
        return(banner);
    }
}