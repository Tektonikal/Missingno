package tektonikal.missingno;

import eu.midnightdust.lib.config.MidnightConfig;

import javax.swing.*;

public class Config extends MidnightConfig {
    @Entry(selectionMode = JFileChooser.FILES_ONLY, fileExtensions = {"png"}, name = "Missing texture file (use png + dimensions multiple of 16)") public static String texture = "";
}
