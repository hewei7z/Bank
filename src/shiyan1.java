import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account{
    private String username;
    private String password;
    private double balancce;
    public Account(String username,String password,double balancce){
        this.username=username;
        this.password=password;
        this.balancce=balancce;
    }
    //存钱
    public void deposit(double money){
        if(money>0){
            balancce+=money;
            System.out.println("余额为："+ balancce);
        }
        else{
            System.out.println("存款余额需大于0");
        }
    }
    //取钱
    public void withdraw(double money){
        if(money>0&&money<=balancce){
            balancce-=money;
            System.out.println("账户余额为："+ balancce);
        }
        else if(money>balancce){
            System.out.println("余额不足");
        }
        else{
            System.out.println("取钱金额应大于0");
        }
    }
    //查看余额
    public double getBalancce(){
        return balancce;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
//银行类
class Bank{
    private String bankname;
    private List<Account> accountList;
    public Bank (String bankname){
        this.bankname=bankname;
        accountList=new ArrayList<>();
    }
    //开户
    public void openAccount(String username,String password,double money){
        Account newacc=new Account(username,password,money);
        accountList.add(newacc);
        System.out.println("开户成功");
    }
    public Account findAccount(String name,String psd){
       for( Account acc:accountList){
           if(acc.getUsername().equals(name)&&acc.getPassword().equals(psd)){
               return acc;
           }
       }
return null;
    }
}

public class shiyan1 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        Bank bank=new Bank("银行");
    while(true){
        System.out.println("银行操作系统");
        System.out.println("1.开户");
        System.out.println("2.存款");
        System.out.println("3.取款");
        System.out.println("4.退出");
        int choice=sc.nextInt();
        sc.nextLine();
        //开始操作
        if(choice==1){
            System.out.println("请输入用户名：");
            String name=sc.nextLine();
            System.out.println("请输入密码：");
            String Password=sc.nextLine();
            System.out.println("请输入存款金额：");
            double money=sc.nextDouble();
            sc.nextLine();
            bank.openAccount(name,Password,money);
        }
        else if(choice==2){
            System.out.println("用户名:");
            String name=sc.nextLine();
            System.out.println("请输入密码:");
            String Password=sc.nextLine();
            Account acc=bank.findAccount(name,Password);
            if(acc==null){
                System.out.println("用户名或密码错误，请重试");
                continue;
            }
            System.out.println("请输入存款金额：");
            double m=sc.nextDouble();
            sc.nextLine();
            acc.deposit(m);
        }
        else if(choice==3){
            System.out.println("用户名:");
            String name=sc.nextLine();
            System.out.println("请输入密码:");
            String Password=sc.nextLine();
            Account acc=bank.findAccount(name,Password);
            if(acc==null){
                System.out.println("用户名或密码错误，请重试");
                continue;
            }
            System.out.println("请输入取款金额：");
            double m=sc.nextDouble();
            sc.nextLine();
            acc.withdraw(m);
        }
        else if(choice==4){
            System.out.println("程序退出");
            break;
        }
        else{
            System.out.println("输入项无效");
        }
    }
    sc.close();
    }
}
