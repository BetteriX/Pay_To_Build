package PayToBuild.App;

import PayToBuild.Data.*;

public  class SaveParts {

    public static String cpuname;
    public static String casename;
    public static String cpucoolername;
    public static String storagename;
    public static String memoryname;
    public static String motherboardname;
    public static String psuname;
    public static String gpuname;
    public static FinalParts parts = new FinalParts();

    public static void SaveParts() {

    }

    public static void SaveCpu(CPU c){
        cpuname = c.getName();
        parts.set_cpu(c);
    }

    public static void SaveStorage(Storage s){
        storagename = s.getName();
        parts.set_storage(s);
    }

    public static void SaveCase(Case c){
        casename = c.getName();
        parts.set_case(c);
    }

    public static void SaveMotherboard(Motherboard m){
        motherboardname = m.getName();
        parts.set_motherboard(m);
    }

    public static void SaveGPU(VideoCard v){
        gpuname = v.getName();
        parts.set_videocard(v);
    }

    public static void SaveCPUCooler(CPUCooler c){
        cpucoolername = c.getName();
        parts.set_cpucooler(c);
    }

    public  static  void SaveMemory(Memory m){
        memoryname = m.getName();
        parts.set_memory(m);
    }

    public static void SavePSU(PSU psu){
        psuname = psu.getName();
        parts.set_psu(psu);
    }

    public static String GetCPUName(){
        if (parts == null || parts.get_cpu() == null) {
            return null;
        }
        return parts.get_cpu().getName();
    }

    public static String GetCaseName(){
        if (parts == null || parts.get_case() == null) {
            return null;
        }
        return parts.get_case().getName();
    }

    public static String GetStorageName(){
        if (parts == null || parts.get_storage() == null) {
            return null;
        }
        return parts.get_storage().getName();
    }

    public static String GetMotherboardName(){
        if (parts == null || parts.get_motherboard() == null) {
            return null;
        }
        return parts.get_motherboard().getName();
    }

    public static String GetGPUName(){
        if (parts == null || parts.get_videocard() == null) {
            return null;
        }
        return parts.get_videocard().getName();
    }

    public static String GetCPUCoolerName(){
        if (parts == null || parts.get_cpucooler() == null) {
            return null;
        }
        return parts.get_cpucooler().getName();
    }

    public static String GetMemoryName(){
        if (parts == null || parts.get_memory() == null) {
            return null;
        }
        return parts.get_memory().getName();
    }

    public static String GetPSUName(){
        if (parts == null || parts.get_psu() == null) {
            return null;
        }
        return parts.get_psu().getName();
    }
}
