/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tectuinno.seriallab.application;

import com.tectuinno.seriallab.core.WorkSpaceProperties;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

/**
 * 
 * @author root
 */
public class WorkSpaceFileStorer {
    
    private static final String WORKSPACE_FILE_NAME = "workspace.json";
    
    private final ObjectMapper mapper;

    public WorkSpaceFileStorer() {
        this.mapper = JsonMapper.builder()                        
                .enable(SerializationFeature.INDENT_OUTPUT)
                .build();
    }
    
    public Path resolveWorkspaceFile(Path workspaceDir) {
        return workspaceDir.resolve(WORKSPACE_FILE_NAME);
    }

    public void save(WorkSpaceProperties props) throws IOException {
        Path dir = Path.of(props.getPath());
        Files.createDirectories(dir);

        Path file = resolveWorkspaceFile(dir);
        mapper.writeValue(file.toFile(), props);
    }

    public WorkSpaceProperties load(Path workspaceDir) throws IOException {
        Path file = resolveWorkspaceFile(workspaceDir);
        return mapper.readValue(file.toFile(), WorkSpaceProperties.class);
    }
    
}
