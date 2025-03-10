package TemplateMethod;

public class Main {
   public static void main(String[] args) {
    var task = new TransferMoneyTask();
    task.execute();
    var task1 = new GenerateReportTask();
    task1.execute();
   }
    
}

class TransferMoneyTask extends Task{
    @Override
    public void doExecute() {
       System.out.println("Transfer Money");
    }

}

class GenerateReportTask extends Task{
    @Override
    public void doExecute() {
        System.out.println("Generate Report");
     }
}

class AuditTrail{
    public void record(){
        System.out.println("Audit");
    }

}

abstract class Task{
    private AuditTrail auditTrail;

    public Task(){
        auditTrail = new AuditTrail();
    }
    public Task (AuditTrail auditTrail){
        this.auditTrail=auditTrail;
    }
    public void execute(){
        auditTrail.record();
        doExecute();
    }

    protected abstract void doExecute();

}
