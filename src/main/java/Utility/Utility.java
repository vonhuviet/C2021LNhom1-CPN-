/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import Connect.Config;
import java.util.Scanner;

/**
 *
 * @author Bun
 */
public class Utility {

    // Ma hoa MD5 mat khau
    public static String getSecurityMD5(String pwd) {
        return MD5(MD5(pwd) + Config.PRIVATE_KEY);
    }

    private static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
    //--------------------------------------------------
    // Chuyen doi Int va Float khong bi loi khi nhap sai
    public static int ScanInt(Scanner scan) {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(scan.nextLine());
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Nhap lai: ");
            }
        }
    }
    
    public static float ScanFloat(Scanner scan) {
        float value;
        while (true) {
            try {
                value = Float.parseFloat(scan.nextLine());
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Nhap lai: ");
            }
        }
    }
    //--------------------------------------------------
    
}
