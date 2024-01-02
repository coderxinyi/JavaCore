package com.xinyi.test;

import java.util.regex.Pattern;

/**
 * @author guxinxin
 * @version 1.0.0
 * @Description TODO
 * @createTime 2023年01月08日 13:01:00
 */
public class TypeDemo {
    public static void main(String[] args) {
        ClassInfo classInfo = new ClassInfo();
        classInfo.setCode("VIP6TVGJ23003");
        classInfo.setName("IB选课探索之IG生物(适合G9-10）");
        classInfo.setClassTypeCode("CTBJ015014001");
        classInfo.setDepartmentCode("DPBJ015");
        String p1v3 = ".*VIP3.*";
        String p1v6 = ".*VIP6.*";
        String withoutNum = ".*VIP[^0-9].*";
        if(classInfo.getCode().startsWith("TXK") && classInfo.getName().contains("美本") && classInfo.getDepartmentCode().equals("DPBJ015")) {
            classInfo.setTypes(18);//VIP一对12
        }else if(classInfo.getDepartmentCode().equals("DPBJ006")){
			/*if (classInfo.getCode().startsWith("AZJ") || classInfo.getCode().startsWith("AZGQC") || classInfo.getCode().startsWith("AZFQC")
					|| classInfo.getCode().startsWith("AZS") || classInfo.getCode().startsWith("AZK") || classInfo.getCode().startsWith("AZI")){

				classInfo.setTypes(41);//小语种全程班
			}else if(classInfo.getCode().startsWith("VIPAJV") || classInfo.getCode().startsWith("VIPADV")|| classInfo.getCode().startsWith("VIPAFV")
					|| classInfo.getCode().startsWith("VIPASV")|| classInfo.getCode().startsWith("VIPAKV")|| classInfo.getCode().startsWith("VIPAIV")){
				classInfo.setTypes(40);//小语种一对一

			}else if( classInfo.getCode().startsWith("AJ") || classInfo.getCode().startsWith("ZAJ") || classInfo.getCode().startsWith("AG")
					|| classInfo.getCode().startsWith("AGTS") || classInfo.getCode().startsWith("ZAG") || classInfo.getCode().startsWith("AF")
					|| classInfo.getCode().startsWith("ZAF") || classInfo.getCode().startsWith("AK") || classInfo.getCode().startsWith("ZAK")
					|| classInfo.getCode().startsWith("AS") || classInfo.getCode().startsWith("ZAS") || classInfo.getCode().startsWith("AI") || classInfo.getCode().startsWith("ZAI")){
				classInfo.setTypes(42);//小语种大班

			}else{*/
            classInfo.setTypes(-1);
            //}
        }else if(classInfo.getDepartmentCode().equals("DPBJ015")){//英联邦
            //英联邦班型改动  lba
            if("VIPYV210414".equals(classInfo.getCode()) || "VIPYV210424".equals(classInfo.getCode())|| "VIPYV210420".equals(classInfo.getCode())|| "VIPYV210413".equals(classInfo.getCode())|| "VIPYV210415".equals(classInfo.getCode())){
                classInfo.setTypes(71);//一对一（全程、计划）
            }else if ("VIPYV210422".equals(classInfo.getCode()) || "VIPYV210421".equals(classInfo.getCode())|| "VIPYV210423".equals(classInfo.getCode())){
                classInfo.setTypes(86);//一对一（全程、计划）
            }else if(classInfo.getCode().startsWith("YVJ")&&(classInfo.getName().contains("中学生") || classInfo.getName().contains("本科") || classInfo.getName().contains("英本"))){
                if("CTBJ015013002".equals(classInfo.getClassTypeCode())){
                    classInfo.setTypes(61);//精英计划项目
                }else{
                    classInfo.setTypes(60);//精英计划1对1
                }
            }else if (classInfo.getCode().startsWith("YVJ")&&(classInfo.getName().contains("大学生") || classInfo.getName().contains("英研"))){//英研
                if("CTBJ015013002".equals(classInfo.getClassTypeCode())){
                    classInfo.setTypes(83);//精英计划项目
                }else{
                    classInfo.setTypes(84);//精英计划1对1
                }
            }else if (classInfo.getCode().startsWith("VIPYVL")) {
                //国际学科A-level
                if(classInfo.getName().contains("计划")){
                    classInfo.setTypes(67);//国际学科A-level 1对1班计划
                }else {
                    classInfo.setTypes(68);//国际学科A-level 1对1班
                }
            }else if (classInfo.getCode().startsWith("VIP2YVL") && classInfo.getName().contains("国际学科")) {
                classInfo.setTypes(127);//国际学科
            }else if (classInfo.getCode().startsWith("VIP2YVDH") && classInfo.getName().contains("计划") && (classInfo.getName().contains("中学生") || classInfo.getName().contains("英本"))) {
                classInfo.setTypes(70);//一对二（计划）
            }else if (classInfo.getCode().startsWith("VIP2YVDH") && classInfo.getName().contains("计划") && (classInfo.getName().contains("大学生") || classInfo.getName().contains("英研"))) {//英研
                classInfo.setTypes(85);//一对二（计划）
            }else if (classInfo.getCode().startsWith("VIP2YV") && !classInfo.getName().contains("计划") && !classInfo.getName().contains("全程") && (classInfo.getName().contains("中学生") || classInfo.getName().contains("英本"))) {
                classInfo.setTypes(69);//一对二（散单）
            }else if (classInfo.getCode().startsWith("VIP2YV") && !classInfo.getName().contains("计划") && !classInfo.getName().contains("全程") && (classInfo.getName().contains("大学生") || classInfo.getName().contains("英研"))) {//英研
                classInfo.setTypes(115);//一对二（散单）
            }else if (classInfo.getCode().startsWith("VIPYVDH") && (classInfo.getName().contains("中学生") || classInfo.getName().contains("英本"))) {
                classInfo.setTypes(71);//一对一（全程、计划）
            }else if (classInfo.getCode().startsWith("VIPYVDH") && (classInfo.getName().contains("大学生") || classInfo.getName().contains("英研"))) {//英研
                classInfo.setTypes(86);//一对一（全程、计划）
            }else if (classInfo.getCode().startsWith("VIPYV") && classInfo.getName().contains("国际学科") && !classInfo.getName().contains("计划") && !classInfo.getName().contains("全程") && !classInfo.getName().contains("英澳名校预科")) {
                classInfo.setTypes(81);//一对一散单（包含国际学科、国际教育1对1）
            }else if (classInfo.getCode().startsWith("VIPYV") && (classInfo.getName().contains("中学生") || classInfo.getName().contains("英本")) && !classInfo.getName().contains("计划") && !classInfo.getName().contains("全程") && !classInfo.getName().contains("英澳名校预科")) {
                classInfo.setTypes(62);//一对一散单（包含雅思）
            }else if (classInfo.getCode().startsWith("VIPYV") && (classInfo.getName().contains("大学生") || classInfo.getName().contains("英研")) && !classInfo.getName().contains("计划") && !classInfo.getName().contains("全程") && !classInfo.getName().contains("英澳名校预科")) {//英研
                classInfo.setTypes(87);//一对一散单（包含雅思）
            }else if (classInfo.getCode().startsWith("VIPYV") && classInfo.getName().contains("英澳名校预科")) {//英研
                classInfo.setTypes(90);//英澳名校预科（计划、散单）
            }else if(classInfo.getCode().startsWith("VIP3YVDH") && classInfo.getName().contains("计划") && (classInfo.getName().contains("中学生") || classInfo.getName().contains("英本"))) {
                classInfo.setTypes(65);//1对3(计划)
            }else if(classInfo.getCode().startsWith("VIP3YV") && !classInfo.getName().contains("计划") && !classInfo.getName().contains("全程")) {
                classInfo.setTypes(98);//1对3(散单)
            }else if(classInfo.getCode().startsWith("VIP6YV") && (classInfo.getName().contains("中学生") || classInfo.getName().contains("英本"))) {
                classInfo.setTypes(63);//IELTS VIP小班（走读班）
            }else if(classInfo.getCode().startsWith("VIP6YV") && (classInfo.getName().contains("大学生") || classInfo.getName().contains("英研"))) {//英研
                classInfo.setTypes(88);//IELTS VIP小班（走读班）
            }else if(classInfo.getCode().startsWith("VIP6JZYV") && (classInfo.getName().contains("中学生") || classInfo.getName().contains("英本"))) {
                classInfo.setTypes(82);//IELTS VIP小班（住宿班）
            }else if(classInfo.getCode().startsWith("VIP6JZYV") && (classInfo.getName().contains("大学生") || classInfo.getName().contains("英研"))) {//英研
                classInfo.setTypes(89);//IELTS VIP小班（住宿班）
            }else if(classInfo.getCode().startsWith("VIP6YAL")) {
                classInfo.setTypes(66);//学科六人定制 lba
            }else if(classInfo.getCode().startsWith("YAX") && classInfo.getName().contains("全程班") && classInfo.getName().contains("英本")){
                classInfo.setTypes(64);//全程班条件及名称  -> 雅思首考12人全程班(无)
            }else if(classInfo.getCode().startsWith("YA") && classInfo.getName().contains("海外")){
                classInfo.setTypes(72);//海外高中英语学分课（预科ESL）
            }else if(classInfo.getCode().startsWith("YA") && classInfo.getName().contains("IGCSE先修课")){
                classInfo.setTypes(79);//IGCSE先修课
            }else if(classInfo.getCode().startsWith("YA") && classInfo.getName().contains("衔接课")){
                classInfo.setTypes(103);//衔接课
            }else if(classInfo.getCode().startsWith("ZYA")){
                classInfo.setTypes(99);//英本外地班
            }else{

                if(classInfo.getCode().startsWith("YVJ")){
                    if("CTBJ015013002".equals(classInfo.getClassTypeCode())){
                        classInfo.setTypes(61);//精英计划项目
                    }else{
                        classInfo.setTypes(60);//精英计划1对1
                    }
                }else if (classInfo.getCode().startsWith("VIPYVL")) {
                    //国际学科A-level
                    if(classInfo.getName().contains("计划")){
                        classInfo.setTypes(67);//国际学科A-level 1对1班计划
                    }else {
                        classInfo.setTypes(68);//国际学科A-level 1对1班
                    }
                }else if (classInfo.getCode().startsWith("VIP2YVDH") && classInfo.getName().contains("计划") ) {
                    classInfo.setTypes(70);//一对二（计划）
                }else if (classInfo.getCode().startsWith("VIP2YV") && !classInfo.getName().contains("计划") && !classInfo.getName().contains("全程") ) {
                    classInfo.setTypes(69);//一对二（散单）
                }else if (classInfo.getCode().startsWith("VIPYVDH")) {
                    classInfo.setTypes(71);//一对一（全程、计划）
                }else if (classInfo.getCode().startsWith("VIPYV")  && !classInfo.getName().contains("计划") && !classInfo.getName().contains("全程")) {
                    classInfo.setTypes(62);//一对一散单（包含雅思、预科、国际学科）
                }else if(classInfo.getCode().startsWith("VIP3YVDH")) {
                    classInfo.setTypes(65);//1对3
                }else if(classInfo.getCode().startsWith("VIP6YV") || classInfo.getCode().startsWith("VIP6JZYV")) {
                    classInfo.setTypes(63);//雅思六人班
                }else if(classInfo.getCode().startsWith("VIP6YAL")) {
                    classInfo.setTypes(66);//学科六人定制 lba
                }else if(classInfo.getCode().startsWith("YA") && classInfo.getName().contains("首考")){
                    classInfo.setTypes(64);//全程班条件及名称  -> 雅思首考18人全程班
                }else if(classInfo.getCode().startsWith("YA") && classInfo.getName().contains("海外高中英语学分课")){
                    classInfo.setTypes(72);//海外高中英语学分课（E级）
                }else if(classInfo.getCode().startsWith("YA") && classInfo.getName().contains("IGCSE先修课")){
                    classInfo.setTypes(79);//IGCSE先修课
                }else{
                    classInfo.setTypes(-1);
                }

            }
        }else{
            if(classInfo.getCode().startsWith("VIPYVXS")
                    && classInfo.getName().contains("探究课") && classInfo.getName().contains("英联邦")){
                classInfo.setTypes(129);//牛剑G5计划子班一对一
            }else if(classInfo.getCode().startsWith("VIPGXS")
                    && classInfo.getName().contains("探究课") && classInfo.getName().contains("英联邦")){
                classInfo.setTypes(130);//学术探究一对一
            }else if(classInfo.getCode().startsWith("VIP6GXS")
                    && classInfo.getName().contains("探究课") && classInfo.getName().contains("英联邦")){
                classInfo.setTypes(131);//学术探究6-8人班
            }else if(classInfo.getCode().contains("VIPGXS")){
                classInfo.setTypes(92);//国际学科学术探究课(一对一)
            }else if (classInfo.getCode().contains("VIP6GXS")) {
                classInfo.setTypes(93);//国际学科学术探究课（一对六）
            }else if (classInfo.getCode().contains("VIP")&&!classInfo.getCode().contains("E")&&!classInfo.getCode().contains("ZSF")) {
                if (!classInfo.getCode().contains("ZD")) {
                    String v =classInfo.getCode().substring(7, classInfo.getCode().length());//班型前缀后面数字
                    if (Pattern.matches(p1v3, classInfo.getCode())) {
                        classInfo.setTypes(1);
                    } else if (Pattern.matches(p1v6, classInfo.getCode())) {
                        classInfo.setTypes(2);//VIP一对六
                    } else if(classInfo.getCode().startsWith("VIPTVGY")){//国际教育1对1班
                        classInfo.setTypes(26);
                    } else if(classInfo.getCode().startsWith("VIPTVXK")){//国际学科VIP
                        classInfo.setTypes(28);
                    } else if (Pattern.matches(withoutNum, classInfo.getCode())) {
                        boolean tmpb = true;
                        if (classInfo.getCode().contains("H") && !classInfo.getCode().contains("G")&& !classInfo.getCode().contains("N")) {
                            classInfo.setTypes(3);//VIP全程班
                            tmpb = false;
                        }
                        if ((!classInfo.getCode().contains("H")) && classInfo.getCode().contains("G")&&!classInfo.getCode().contains("TVG")) {
                            classInfo.setTypes(4);//VIP托管班
                            tmpb = false;
                        }
                        if (classInfo.getCode().startsWith("VIPTVFT") ||classInfo.getCode().startsWith("VIPTVST") ||classInfo.getCode().startsWith("VIPTVAT")) {
                            classInfo.setTypes(4);//VIP托管班
                            tmpb = false;
                        }
                        if (classInfo.getCode().contains("N") || classInfo.getCode().contains("K")) {
                            classInfo.setTypes(17);//英语学习VIP（英语学习部门）
                            tmpb = false;
                        }
                        if (tmpb) {
                            classInfo.setTypes(0);//VIP一对一
                        }

                    } else {
                        classInfo.setTypes(0);
                    }
                } else if(classInfo.getCode().startsWith("VIPTVFTZD") ||classInfo.getCode().startsWith("VIPTVSTZD") ||classInfo.getCode().startsWith("VIPTVATZD")) {
                    classInfo.setTypes(4);//VIP托管班指导课
                } else {
                    classInfo.setTypes(5);
                }
                if(classInfo.getCode().startsWith("VIPW")){//美本外地一对一
                    if(classInfo.getCode().startsWith("VIPWFGZ")||classInfo.getCode().startsWith("VIPWSGZ")||classInfo.getCode().startsWith("VIPWAGZ")){//托管住宿
                        classInfo.setTypes(23);
                    }else if(classInfo.getCode().startsWith("VIPWFG")||classInfo.getCode().startsWith("VIPWSG")||classInfo.getCode().startsWith("VIPWAG")){//托管走读
                        classInfo.setTypes(22);
                    }else if(classInfo.getCode().startsWith("VIPWF")||classInfo.getCode().startsWith("VIPWS")||classInfo.getCode().startsWith("VIPWA")||classInfo.getCode().startsWith("VIPWP")){//一对一
                        classInfo.setTypes(21);
                    }else if(classInfo.getCode().startsWith("VIPWGH")){//规划课
                        classInfo.setTypes(24);
                    }
                }
            } else if (classInfo.getCode().startsWith("YGP")) {
                if (classInfo.getCode().startsWith("YGPD")){
                    classInfo.setTypes(105);//Global You 小学生预备单项班
                }else{
                    classInfo.setTypes(27);//Global You 小学生预备班
                }
            }  else if (classInfo.getCode().startsWith("TPF")) {
                // FCE冲分班
                classInfo.setTypes(74);
            }  else if (classInfo.getCode().startsWith("TFE")) {
                // FCE全程班
                classInfo.setTypes(91);
            }  else if (classInfo.getCode().startsWith("TPE")) {
                // PET全程班
                classInfo.setTypes(75);
            }  else if (classInfo.getCode().startsWith("TPYB")) {
                // KET冲分班
                classInfo.setTypes(106);
            }  else if (classInfo.getCode().startsWith("TPC")) {
                // PET冲分班
                classInfo.setTypes(107);
            }  else if (classInfo.getCode().startsWith("TPA")) {
                // KET全程班
                classInfo.setTypes(108);
            } else if (classInfo.getCode().startsWith("TXK")&&classInfo.getDepartmentCode().equals("DPBJ001")) {
                if(classInfo.getCode().startsWith("TXKYB")){//美本本地
                    classInfo.setTypes(57);//新高一学科预备
                }else{
                    classInfo.setTypes(18);//VIP一对12
                }
            } else if ((classInfo.getCode().startsWith("TVFT") ||classInfo.getCode().startsWith("TVST")||classInfo.getCode().startsWith("TVAT"))&&classInfo.getDepartmentCode().equals("DPBJ001")) {

                classInfo.setTypes(4);//VIP托管班
            } else if (classInfo.getCode().startsWith("TVFY")&&classInfo.getDepartmentCode().equals("DPBJ001")) {

                classInfo.setTypes(104);//美研学术写作单项班
            } else if (classInfo.getCode().startsWith("TVG")) {
                // 精英A计划320小时、420小时，精英B计划，精英C计划，精英D计划，统一为精英计划
                // 其他精英计划为，零散一对一
                if(classInfo.getCode().contains("ZD")){
                    //美高精英计划指导课
                    classInfo.setTypes(109);
                }else if(classInfo.getCode().contains("GH")){
                    //美高精英计划规划课
                    classInfo.setTypes(110);
                }else if (classInfo.getName() != null) {
                    if (classInfo.getName().contains("精英A计划")) {
                        if (classInfo.getName().contains("320小时") || classInfo.getName().contains("420小时")) {
                            //美高精英计划
                            classInfo.setTypes(6);
                        } else {
                            //美高零散1对1
                            classInfo.setTypes(7);
                        }
                    } else {
                        classInfo.setTypes(6);
                    }
                }
            }else if(classInfo.getCode().startsWith("TSWZ")){//美本外地
                classInfo.setTypes(16);
            }else if(classInfo.getCode().startsWith("TS") &&classInfo.getName().contains("美本")&&classInfo.getDepartmentCode().equals("DPBJ001")){
                //美本本地
                if(classInfo.getCode().startsWith("TSYCF")||(classInfo.getCode().startsWith("TSB")&&classInfo.getName().contains("SAT冲分")) ||(classInfo.getCode().startsWith("TSB")&&classInfo.getName().contains("SAT*I冲分"))){//SAT冲分
                    classInfo.setTypes(49);
                }else if(classInfo.getCode().startsWith("TSYTX")||(classInfo.getCode().startsWith("TSB")&&classInfo.getName().contains("SAT考前特训"))){//SAT考前特训班
                    classInfo.setTypes(122);
                }else if(classInfo.getCode().startsWith("TSD")){//SAT精讲精练
                    classInfo.setTypes(50);
                }else if(classInfo.getCode().startsWith("TSYQC")||classInfo.getCode().startsWith("TSQP")){//SAT全程
                    classInfo.setTypes(51);
                }else if(classInfo.getName().contains("SAT强化")){//SAT强化
                    classInfo.setTypes(123);
                }/*else if(classInfo.getCode().startsWith("TSS")){//SAT2班
					classInfo.setTypes(59);
				}else{
					classInfo.setTypes(48);//SAT
				}*/
            }else if (classInfo.getCode().startsWith("TF") && classInfo.getDepartmentCode().equals("DPBJ001")) {
                //美高大班（ 朱尼尔）
                if(classInfo.getCode().contains("TFJC") || classInfo.getCode().contains("TFJM")){
                    if(classInfo.getName() !=null &&classInfo.getName().contains("美高")){

                        classInfo.setTypes(8);
                    }
                }
                if(classInfo.getName() !=null &&classInfo.getName().contains("美高")){

                    classInfo.setTypes(8);
                }
                //美高托管
                if(classInfo.getCode().startsWith("TFT")){
                    if(classInfo.getCode().contains("ZD")){
                        //美高托管指导课班
                        classInfo.setTypes(111);
                    }else if(classInfo.getCode().contains("GH")){
                        //美高托管规划课班
                        classInfo.setTypes(112);
                    }else if(classInfo.getName() !=null &&classInfo.getName().contains("美高")){
                        //美高托管班
                        classInfo.setTypes(113);
                    }
                }
                //美本外地
                if(classInfo.getCode().startsWith("TFWZ")){
                    classInfo.setTypes(16);
                }
                //美本本地
                if(classInfo.getName() !=null &&classInfo.getName().contains("美本")){

                    if(classInfo.getCode().startsWith("TFC")){//TOEFL基础
                        classInfo.setTypes(44);
					/*}else if(classInfo.getCode().startsWith("TFHB")){//TOEFL词汇
						classInfo.setTypes(45);*/
                    }else if(classInfo.getCode().startsWith("TFJL")){//TOEFL精讲精练
                        classInfo.setTypes(46);
                    }else if(classInfo.getCode().startsWith("TFJX")){//TOEFL精析班
                        classInfo.setTypes(117);
                    }else if(classInfo.getName().contains("TOEFL强化")){//TOEFL强化班
                        classInfo.setTypes(118);
                    }else if(classInfo.getName().contains("TOEFL冲分")){//TOEFL冲分班
                        classInfo.setTypes(119);
                    }else if(classInfo.getCode().startsWith("TFK")){//TOEFL冲刺特训班
                        classInfo.setTypes(120);
                    }else if(classInfo.getCode().startsWith("TFX")){//TOEFL全程班
                        classInfo.setTypes(47);
                    }else{
                        //classInfo.setTypes(43);//托福
                    }
                }
                if(classInfo.getCode().startsWith("TFGJ")){//国际高中加试
                    classInfo.setTypes(56);
                }
                //美研班课
                if(classInfo.getName() !=null &&classInfo.getName().contains("美研")){

                    classInfo.setTypes(14);
                }
                //美本本地合作办学  美本本地
                if(classInfo.getCode().startsWith("TF") && classInfo.getName().contains("北美企业培训") ){
                    if(classInfo.getName().contains("人朝分") || classInfo.getName().contains("西山") ){
                        classInfo.setTypes(78);
                    }
                }
                //美研班课-----北美企业培训班（美研）
                if(classInfo.getCode().startsWith("TFC") && classInfo.getName().contains("北美企业培训班（美研）") ){
                    classInfo.setTypes(126);
                }
            } else if (classInfo.getCode().startsWith("TN") && classInfo.getDepartmentCode().equals("DPBJ001")) {//美本
                //TOEFL提能班
                classInfo.setTypes(121);
            } else if (classInfo.getCode().startsWith("TA") && classInfo.getDepartmentCode().equals("DPBJ001")) {
                // 美高----SSAT强化12人
                if(classInfo.getCode().startsWith("TA") && classInfo.getName().contains("SSAT")){
                    classInfo.setTypes(76);
                }
                // ACT精讲精练
				/*if(classInfo.getCode().startsWith("TAD")){
					classInfo.setTypes(77);
				}*/
                //美高大班（ssat、美国中学同步课程）
                if(classInfo.getCode().contains("TAQC")){
                    if(classInfo.getName() !=null &&classInfo.getName().contains("美高")){
                        classInfo.setTypes(8);
                    }
                }
                if( classInfo.getCode().contains("TAMS") || classInfo.getCode().contains("TAML") || classInfo.getCode().contains("TAMC")){

                    if(classInfo.getName() !=null &&classInfo.getName().contains("美高")){

                        classInfo.setTypes(8);
                    }
                }

                if(classInfo.getName() !=null &&classInfo.getName().contains("美本")){
                    //美本本地
                    if(classInfo.getCode().startsWith("TAB")){//ACT考前特训班
                        classInfo.setTypes(124);
                        if(classInfo.getName().contains("ACT冲分")){//ACT冲分
                            classInfo.setTypes(53);
                        }
                    }else if(classInfo.getCode().startsWith("TAQP")){//ACT全程
                        classInfo.setTypes(54);
                    }else if(classInfo.getCode().startsWith("TAD")){//ACT精讲精练
                        classInfo.setTypes(77);
                    }else if(classInfo.getCode().startsWith("TAT")&&classInfo.getName().contains("ACT强化")){//ACT强化
                        classInfo.setTypes(55);
                    }else if(classInfo.getCode().startsWith("TAP")&&classInfo.getName().contains("AP强化")){//AP班
                        classInfo.setTypes(58);
                    }else if(classInfo.getCode().startsWith("TAPB")){//AP校内同步课
                        classInfo.setTypes(125);
                    }

                }

                if(classInfo.getCode().startsWith("TAMH")){
                    classInfo.setTypes(80);//美本本地
                    if(classInfo.getName() !=null &&classInfo.getName().contains("美高")){
                        //classInfo.setTypes(52);
                        classInfo.setTypes(8);//美高大班
                    }
                }
				/*if(classInfo.getCode().startsWith("TAMH") &&classInfo.getName().contains("初中生留学预备课")){
                    //classInfo.setTypes(52);
					classInfo.setTypes(80);
				}*/
                if(classInfo.getCode().startsWith("TAWZ")){//美本外地

                    classInfo.setTypes(16);
                }
            } else if (classInfo.getCode().startsWith("TVYA")|| classInfo.getCode().startsWith("TVYB")|| classInfo.getCode().startsWith("TVYC")|| classInfo.getCode().startsWith("TVYD")|| classInfo.getCode().startsWith("TVYE")) {//美研
                classInfo.setTypes(12);//美研精英计划
            } else if (classInfo.getCode().startsWith("TVJ")) {
                if (classInfo.getCode().startsWith("TVJA") ||classInfo.getCode().startsWith("TVJB")||classInfo.getCode().startsWith("TVJC")||classInfo.getCode().startsWith("TVJD")||classInfo.getCode().startsWith("TVJS")){
                    classInfo.setTypes(10);//美本精英计划10（2020.8.12去掉）美本精英计划卡班10(2022.3.8增加)
                }else if (classInfo.getCode().startsWith("TVJX")){
                    //美本精英计划单项班 助教需要 lba
                    classInfo.setTypes(73);
                } else if(classInfo.getCode().startsWith("TVJM")){
                    classInfo.setTypes(11);//美本精英计划规划课
                }else if(classInfo.getCode().startsWith("TVJY")){
                    classInfo.setTypes(13);//美研精英计划1对1
                }else if(classInfo.getCode().startsWith("TVJGH")){
                    classInfo.setTypes(38);//美研规划课
                }else{
                    classInfo.setTypes(9);//美本精英计划一对一
                }
            } else if ( classInfo.getCode().startsWith("01ZTF")|| classInfo.getCode().startsWith("ZTS")
                    || classInfo.getCode().startsWith("ZTAT") || classInfo.getCode().startsWith("ZTAP")
                    || classInfo.getCode().startsWith("ZTFQC") ||classInfo.getCode().startsWith("ZTFP") ||classInfo.getCode().startsWith("ZTFJQC")) {
                //美本外地
                if(classInfo.getCode().startsWith("ZTS")){
                    classInfo.setTypes(96);//SAT牛人
                } else if(classInfo.getCode().startsWith("ZTFQC")){
                    classInfo.setTypes(114);//美本外地计划班号
                } else if(classInfo.getCode().startsWith("ZTFJQC")){
                    classInfo.setTypes(97);//TOEFL JUNIOR全程班
                }else{
                    classInfo.setTypes(16);
                }
            } else if (classInfo.getCode().startsWith("TVQYTG")){
                /** 美研托管班*/
                classInfo.setTypes(128);
            }else if(classInfo.getCode().startsWith("TVQYZD")){
                /** 美研指导课*/
                classInfo.setTypes(132);
            }else if ( classInfo.getCode().startsWith("TVQYT")|| classInfo.getCode().startsWith("TVQYR")|| classInfo.getCode().startsWith("TVQYA") || classInfo.getCode().startsWith("TVQYM") || classInfo.getCode().startsWith("TVQYL")) {
                //美研小时包
                classInfo.setTypes(37);
            } else if ( classInfo.getCode().startsWith("TVQY6T") || classInfo.getCode().startsWith("TVQY6R") || classInfo.getCode().startsWith("TVQY6M")) {
                //美研6人班
                classInfo.setTypes(116);
            } else if ( classInfo.getCode().startsWith("ZTVJY")) {
                //美研直通计划1对1
                classInfo.setTypes(35);
            } else if ( classInfo.getCode().startsWith("HTVJY")) {
                //美研攀藤计划一对一
                classInfo.setTypes(36);
            } else if ( classInfo.getCode().startsWith("TG") || classInfo.getCode().startsWith("TR")   || classInfo.getCode().startsWith("ZTG")
                    || classInfo.getCode().startsWith("ZTF") || classInfo.getCode().startsWith("02ZTF")
                    || classInfo.getCode().startsWith("ZTR") || classInfo.getCode().startsWith("TWXS")) {
                //美本外地
                if(classInfo.getCode().startsWith("02ZTFOC")){
                    //美本外地计划班号
                    classInfo.setTypes(114);
                }else if(classInfo.getCode().startsWith("ZTFC")){
                    classInfo.setTypes(16);
                    //美研班课
                }else if(classInfo.getCode().startsWith("TWXS")){
                    classInfo.setTypes(100);//TOEFL线上全程班
                }else if(classInfo.getCode().startsWith("TRWL")){
                    classInfo.setTypes(101);//GRE线上全程班
                }else if(classInfo.getCode().startsWith("TGWL")){
                    classInfo.setTypes(102);//GMAT线上全程班
                }else if(classInfo.getName() !=null &&classInfo.getName().contains("美研") && classInfo.getDepartmentCode().equals("DPBJ001")
                        && ( classInfo.getCode().startsWith("TR")|| classInfo.getCode().startsWith("ZTR")
                        || classInfo.getCode().startsWith("ZTG") || classInfo.getCode().startsWith("TG") || classInfo.getCode().startsWith("02ZTF"))){

                    if(classInfo.getCode().startsWith("ZTFGA")|| classInfo.getCode().startsWith("ZTFGB")|| classInfo.getCode().startsWith("ZTFGC")){
                        classInfo.setTypes(34);//美研直通计划
                    }else{
                        classInfo.setTypes(14);
                    }
                }else if(classInfo.getCode().startsWith("TGXS")){
                    classInfo.setTypes(94);//国际学科学术探究课（12人）
                }else if(classInfo.getCode().startsWith("02ZTF")&&classInfo.getName().contains("美本")){
                    classInfo.setTypes(95);//美本外地-托福冲分

                }else{
                    classInfo.setTypes(-1);
                }
            }else{
                classInfo.setTypes(-1);
            }
        }
        //未分配的都置位 -1
        if(classInfo.getTypes() == null){
            classInfo.setTypes(-1);
        }
        System.out.println("classInfo" + classInfo);
    }
}
class ClassInfo{
    String code;
    String name;
    Integer types;
    String departmentCode;
    String classTypeCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getClassTypeCode() {
        return classTypeCode;
    }

    public void setClassTypeCode(String classTypeCode) {
        this.classTypeCode = classTypeCode;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", types=" + types +
                ", departmentCode='" + departmentCode + '\'' +
                ", classTypeCode='" + classTypeCode + '\'' +
                '}';
    }
}
