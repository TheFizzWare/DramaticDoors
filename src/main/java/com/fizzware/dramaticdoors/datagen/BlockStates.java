package com.fizzware.dramaticdoors.datagen;

import com.fizzware.dramaticdoors.compat.ModCompatModule;
import com.fizzware.dramaticdoors.init.DoorMaterial;
import com.fizzware.dramaticdoors.util.Ref;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.*;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.Direction;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

public class BlockStates extends BlockStateProvider {

    public static final Logger LOGGER = LogManager.getLogger();

    public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Ref.MOD_ID, exFileHelper);
    }

    protected void registerStatesAndModels() {
        Queue<File> filesToSearch = new PriorityQueue<>();
        Queue<File> filesToCopyMaster = new PriorityQueue<>();
        String original_keyword = "acacia";
        filesToSearch.add(new File("../src/main/resources"));
        while (!filesToSearch.isEmpty()) {
            File first = filesToSearch.remove();
            if (first != null && first.exists()) {
                if (first.isDirectory()) {
                    LOGGER.debug("searching " + first.getAbsolutePath());
                    File[] children = first.listFiles();
                    if (children != null) {
                        Collections.addAll(filesToSearch, children);
                    }
                } else {
                    if (first.getAbsolutePath().contains(original_keyword) && first.getAbsolutePath().contains(".json")) {
                        LOGGER.debug("\twill copy " + first.getAbsolutePath());
                        filesToCopyMaster.add(first);
                    }
                }
            }
        }

        List<String> keywords = new LinkedList<>();
        for (ModCompatModule mod : ModCompatModule.values()) {
            if (!mod.isDisabled()) {
                DoorMaterial[] materials = DoorMaterial.DoorGroup.getByModId(mod.getName()).getGroupMaterials();
                for (DoorMaterial material : materials) {
                    keywords.add(material.getKeyword());
                }
            }
        }
        while (!filesToCopyMaster.isEmpty()) {
            File next = filesToCopyMaster.remove();
            for (String keyword : keywords) {
                FileWriter writer = null;
                Scanner scanner = null;
                String outputFilename = next.getAbsolutePath().replaceAll(original_keyword, keyword).replaceAll("resources", "generated_resources");
                String outputFilenameParent = outputFilename.substring(0, outputFilename.lastIndexOf('\\'));
                File outputDir = new File(outputFilenameParent);
                boolean madeDirs = outputDir.mkdirs();
                try {
                    scanner = new Scanner(next);
                    File outputFile = new File(outputFilename);
                    if (outputFile.exists()) {
                        continue;
                    }
                    LOGGER.debug("\tcreating " + outputFilename);
                    boolean madeFile = outputFile.createNewFile();
                    if (madeFile) {
                        LOGGER.debug("\tsuccessfully created " + outputFilename);
                    } else {
                        LOGGER.fatal("\tFAILED TO CREATE " + outputFilename);
                    }
                    outputFile = new File(outputFilename);
                    writer = new FileWriter(outputFile, false);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String newLine = line.replaceAll(original_keyword, keyword);
                        writer.write(newLine);
                        writer.write('\n');
                        writer.flush();
                    }
                    writer.close();
                    scanner.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        for (String s : keywords) {
//            LOGGER.fatal(s);
//        }
    }
}
