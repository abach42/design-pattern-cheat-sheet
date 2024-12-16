package com.abach42.designpatterns.unit.structural.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.abach42.designpatterns.structural.composite.File;
import com.abach42.designpatterns.structural.composite.Folder;

public class CompositeTest {
    
    @Test
    @DisplayName("File and Folderstructure as expected, both compatible")
    void testCompositePattern() {
        File file1 = new File("file1.txt", 120);
        File file2 = new File("file2.txt", 200);
        File file3 = new File("file3.txt", 50);
        Folder folder1 = new Folder("Folder1");
        Folder folder2 = new Folder("Folder2");

        // Add files to folder1
        folder1.addComponent(file1);
        folder1.addComponent(file2);

        // Add folder1 to folder2
        folder2.addComponent(folder1);

        // Add file3 directly to folder2
        folder2.addComponent(file3);

        // Get the folder structure
        String expectedDetails = "Folder: Folder2\n" +
                                 "  Folder: Folder1\n" +
                                 "   File: file1.txt (Size: 120 KB)\n" +
                                 "   File: file2.txt (Size: 200 KB)\n" +
                                 "\n" + 
                                 "   File: file3.txt (Size: 50 KB)\n"; //ident could be managed, 
                                 // but simplicity of cheat cheet more important
        assertEquals(expectedDetails, folder2.showDetails());
    }
}
