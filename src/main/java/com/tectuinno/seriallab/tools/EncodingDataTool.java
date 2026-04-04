/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tectuinno.seriallab.tools;

/**
 * Herramientas necesarias para convertir de Hexadecimal a ASCII y al revez
 *
 * @author pablo-g
 */
public class EncodingDataTool {

    private EncodingDataTool() {
    }

    /**
     * Convierte un {@code String} en formato ASCII a su equivalente en Hexadecimal
     * @param asciiStr
     * @return un nuevo {@code String} con el mensaje convertido a hexadecimal
     */
    public static String asciiToHex(String asciiStr) {
        char[] chars = asciiStr.toCharArray();
        StringBuilder hex = new StringBuilder();
        for (char ch : chars) {
            hex.append(Integer.toHexString((int) ch));
        }

        return hex.toString();
    }

    
    /**
     * Convierte un {@code String} en formato exadecimal a su equivalent e formato ASCII
     * @param hexStr
     * @return un nuevo {@code String} con el mensaje convertido en ASCII
     */
    private static String hexToAscii(String hexStr) {
        StringBuilder output = new StringBuilder("");

        for (int i = 0; i < hexStr.length(); i += 2) {
            String str = hexStr.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }

        return output.toString();
    }

}
