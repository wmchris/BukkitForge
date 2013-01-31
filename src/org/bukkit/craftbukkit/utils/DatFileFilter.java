package org.bukkit.craftbukkit.utils;

import java.io.File;
import java.io.FilenameFilter;

public class DatFileFilter implements FilenameFilter {
    public boolean accept(File dir, String name) {
        return name.endsWith(".dat");
    }
}
