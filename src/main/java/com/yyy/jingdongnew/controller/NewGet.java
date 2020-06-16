//package com.yyy.jingdongnew.controller;
//
///**
// * @ClassName NewGet
// * @Description TODO
// * @Author yuyao.yang
// * @Date 2020/6/16 17:22
// */
//public class NewGet {
//    public static void main(String[] args) {
//        String html = Models.readTxtFile("E:\\tmpTxt\\test0703.html");
//        String any ="[\\s\\S]*" ;//任何东西
//        StringBuffer regex = new StringBuffer("");
//        regex.append("(number.*)").append(any);//目标字段，下同
//        regex.append("(intLoginType.*)").append(any);
//        regex.append("(areaCode.*)").append(any);
//        regex.append("(isBusinessCustType.*)").append(any);
//        regex.append("(identifyType.*)").append(any);
//        regex.append("(userLoginType.*)").append(any);
//        regex.append("(password.*)").append(any);
//        regex.append("(randomPass.*)").append(any);
//        regex.append("(noCheck.*)").append(any);
//        regex.append("(isSSOLogin.*)").append(any);
//        regex.append("(sRand.*)").append(any);
//        Pattern p = Pattern.compile(regex.toString());
//        Matcher m = p.matcher(html);
//        int countAll = m.groupCount();
//        StringBuffer json = new StringBuffer("{");
//        if(m.find())
//            for (int i=1;i<=countAll;i++){
//                json.append(m.group(i)) ;
//            }
//        System.out.println(json.append("}").toString() );
//
//
//    }
//
//
//
//}
