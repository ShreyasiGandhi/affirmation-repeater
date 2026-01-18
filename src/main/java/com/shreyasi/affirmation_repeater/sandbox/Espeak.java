package com.shreyasi.affirmation_repeater.sandbox;

import java.io.IOException;
import java.util.List;

public class Espeak {
    public static void main(String[] args)throws IOException, InterruptedException  {
        String espeakExe = "C:\\Program Files\\eSpeak NG\\espeak-ng.exe";

        List<String> command = List.of(
                espeakExe,
                "-v", "en+f3",
                "-s", "140",
                "-p", "50",
                "-a", "190",
                "-g", "12",
                "I am calm... I am safe... I trust myself completely."
        );
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.inheritIO();

        Process process = pb.start();
        process.waitFor();
        pb.inheritIO();

        int exitCode = process.waitFor();
        System.out.println("eSpeak exited with code: " + exitCode);

    }
}
