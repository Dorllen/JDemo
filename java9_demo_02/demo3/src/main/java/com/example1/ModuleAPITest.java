package com.example1;

import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ModuleAPITest {
    public static void main(String[] args) {
        Path path = Paths.get("");
        ModuleFinder finder = ModuleFinder.of(path);
        ModuleReference module = finder.find("").get();
        ModuleDescriptor desc = module.descriptor();
    }
}
