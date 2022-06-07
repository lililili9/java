package cn.edu.ject;

import java.util.Scanner;

public class lmt {
    public static void main(String[] args) {
        int count = 1;
        int redFlag = 1;
        stu a[] = new stu[1];
        a[0] = new stu("84G0235", "小李", "男", 21, 89);


        Scanner scan = new Scanner(System.in);
        lmt test = new lmt();
        System.out.println("欢迎来到学生信息管理系统");
        while (redFlag == 1) {
            test.putMenu();
            int data0 = scan.nextInt();
            switch (data0) {
                case 0:
                    redFlag = 0;
                    break;
                case 1:
                    test.putAllStu(a, count);
                    break;
                case 2:
                    a = test.inPutStu(a, count,scan);
                    count++;

                    // 如果数组中已实例化元素个数等于a的长度，扩容
                    break;
                case 3:
                    test.selectStu(a, count, scan);
                    break;
                case 4:
                    a = test.reSetStu(a, count , scan);
                    break;
                case 5:
                    a = test.delete(a, count, scan);
                    count--;
                    break;
            }

        }

    }

    void putMenu() {
        System.out.println("<————————————————————>");
        System.out.println("请输入你所要操作的项目标号");
        System.out.println("1.显示所有学生信息");
        System.out.println("2.录入学生信息");
        System.out.println("3.查询学生信息");
        System.out.println("4.修改学生信息");
        System.out.println("5.删除学生信息");
        System.out.println("0.退出系统");
    }// 显示所有学生信息。

    stu[] putAllStu(stu a[], int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(i + 1 + ":");
            System.out.print("学号：" + a[i].getStuNum());
            System.out.print(" 姓名：" + a[i].getName());
            System.out.print(" 性别：" + a[i].getGender());
            System.out.print(" 年龄：" + a[i].getAge());
            System.out.println(" 成绩：" + a[i].getMark());

        }
        return a;

    }// 显示所有学生信息。

    stu[] inPutStu(stu a[], int count, Scanner scan) {
        if (count == a.length) {
            a = lmt.newArray(a);
        }

        System.out.println("请输入录入学生学号：");
        String newStuNum = scan.next().trim();

        System.out.println("请输入录入学生姓名：");
        String newName = scan.next().trim();

        System.out.println("请输入录入学生性别：");
        String newGender = scan.next().trim();
        while (true) {
            if (newGender.equals("男") || newGender.equals("女")) {
                break;
            } else {
                System.out.println("输入有误，重新输入");
                newGender = scan.next();
            }

        }

        System.out.println("请输入录入学生年龄：");
        int newAge = scan.nextInt();

        System.out.println("请输入录入学生成绩：");
        int newMake = scan.nextInt();

        a[count] = new stu(newStuNum, newName, newGender, newAge, newMake);

        return a;
    }// 录入学生信息。

    void selectStu(stu a[], int count , Scanner scan) {
        System.out.println("请输入要查找的学生姓名：");
        String name = scan.next().trim();
        for (int i = 0; i < count; i++) {
            if (a[i].getName().equals(name)) {
                System.out.print("学号：" + a[i].getStuNum());
                System.out.print(" 姓名：" + a[i].getName());
                System.out.print(" 性别：" + a[i].getGender());
                System.out.print(" 年龄：" + a[i].getAge());
                System.out.print(" 成绩：" + a[i].getMark());
                System.out.println(" 在系统中的位置为：" + i);

                return ;
            }
        }
        System.out.println("查无此人");
        return ;
    }// 查找学生信息。

    stu[] reSetStu(stu a[], int count, Scanner scan) {
        System.out.println("请输入要修改的学生学号：");
        String stuNum = scan.next().trim();
        for (int i = 0; i < count; i++) {
            if (a[i].getStuNum().equals(stuNum)) {
                System.out.println("您将要修改的学生信息如下：");
                System.out.print("学号：" + a[i].getStuNum());
                System.out.print(" 姓名：" + a[i].getName());
                System.out.print(" 性别：" + a[i].getGender());
                System.out.print(" 年龄：" + a[i].getAge());
                System.out.println(" 成绩：" + a[i].getMark());
                System.out.println("请选择您要修改的项目，输入0退出");
                System.out.println("1.学号：");
                System.out.println("2.姓名：");
                System.out.println("3.性别：");
                System.out.println("4.年龄：");
                System.out.println("5.成绩：");
                int flag = 1;
                while (flag != 0) {
                    flag = scan.nextInt();
                    switch (flag) {
                        case 1:
                            System.out.println("请输入新的信息");
                            String newStuNum = scan.next();
                            a[i].setStuNum(newStuNum);
                            break;
                        case 2:
                            System.out.println("请输入新的信息");
                            String newName = scan.next();
                            a[i].setStuNum(newName);
                            break;
                        case 3:
                            System.out.println("请输入新的信息");
                            String newGender = scan.next();
                            while (true) {
                                if (newGender.equals("男") || newGender.equals("女")) {
                                    break;
                                } else {
                                    System.out.println("输入有误，重新输入");
                                    newGender = scan.next();
                                }

                            }
                            a[i].setStuNum(newGender);
                            break;
                        case 4:
                            System.out.println("请输入新的信息");
                            int newAge = scan.nextInt();
                            a[i].setAge(newAge);
                            break;
                        case 5:
                            System.out.println("请输入新的信息");
                            int newMark = scan.nextInt();
                            a[i].setMark(newMark);
                            break;
                        default:
                            System.out.println("请输入正确数字");
                    }
                    System.out.println("请继续选择您要修改的项目，输入0退出");
                }
                System.out.println("您修改后的学生信息如下：");
                System.out.print("学号：" + a[i].getStuNum());
                System.out.print(" 姓名：" + a[i].getName());
                System.out.print(" 性别：" + a[i].getGender());
                System.out.print(" 年龄：" + a[i].getAge());
                System.out.println(" 成绩：" + a[i].getMark());

                return a;
            }

        }
        System.out.println("系统中无此学生");
        return a;
    }// 修改学生信息。

    stu[] delete(stu a[], int count, Scanner scan) {
        System.out.println("请输入要删除的学生学号：");
        String stuNum = scan.nextLine();
        for (int i = 0; i < count; i++) {
            if (a[i].getStuNum().equals(stuNum)) {
                for (int j = i + 1; j < count; j++) {
                    a[j - 1] = a[j];
                }
                return a;
            }
        }
        System.out.println("系统中无此学生");
        return a;
    }// 删除学生信息

    static stu[] newArray(stu a[]) {
        stu[] newArray = new stu[a.length + a.length];
        for (int i = 0; i < a.length; i++)
            newArray[i] = a[i];
        return newArray;
    }
}// 数组扩容


class stu {
    private String stuNum ;//学生学号
    private String name;//学生姓名
    private String gender;//学生性别
    private int age;//学生年龄
    private int mark;//学生成绩

    public stu(String stuNum, String name, String gender, int age, int mark) {
        this.stuNum = stuNum;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.mark = mark;
    }//构造方法

    public String getStuNum() {
        return stuNum;
    }
    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        if(gender != "男"&&gender != "女") {
            System.out.println("输入有误，重新操作");
            return ;
        }

        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }

}

