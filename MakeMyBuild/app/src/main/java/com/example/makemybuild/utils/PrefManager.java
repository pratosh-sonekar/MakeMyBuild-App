package com.example.makemybuild.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_BUDGET = "budget";
    private static final String KEY_BREED = "breed";
    private static final String PREF_NAME = "com.o2o";
    private static final String KEY_SSD="ssd";
    private static final String KEY_RAM="ram";
    private static final String CPU_MODEL="cpumodel";
    private static final String GPU_MODEL="gpumodel";
    private static final String RAM_MODEL="rammodel";
    private static final String MB_MODEL="mbmodel";
    private static final String CABINET_MODEL="cabinetmodel";
    private static final String SSD_MODEL="ssdmodel";
    private static final String HDD_MODEL="hddmodel";
    private static final String PSU_MODEL="psumodel";
    private static final String COOLER_MODEL="coolermodel";
    private static final String MONITOR_MODEL="monitormodel";
    private static final String MOUSE_MODEL="mousemodel";
    private static final String KEYBOARD_MODEL="keyboardmodel";

    private static final String CPU_PRICE="cpuprice";
    private static final String GPU_PRICE="gpuprice";
    private static final String RAM_PRICE="ramprice";
    private static final String MB_PRICE="motherboardprice";
    private static final String CABINET_PRICE="cabinetprice";
    private static final String SSD_PRICE="ssdprice";
    private static final String HDD_PRICE="hddprice";
    private static final String PSU_PRICE="psuprice";
    private static final String COOLER_PRICE="coolerprice";
    private static final String MONITOR_PRICE="monitorprice";
    private static final String MOUSE_PRICE="mouseprice";
    private static final String KEYBOARD_PRICE="keyboardprice";

    private static final String EMAIL="email";
    private static final String CPU_DESC="cpudesc";
    private static final String GPU_DESC="gpudesc";
    private static final String RAM_DESC="ramdesc";
    private static final String MB_DESC="motherboarddesc";
    private static final String CABINET_DESC="cabinetdesc";
    private static final String SSD_DESC="ssddesc";
    private static final String HDD_DESC="hdddesc";
    private static final String PSU_DESC="psudesc";
    private static final String COOLER_DESC="coolerdesc";
    private static final String MONITOR_DESC="monitordesc";
    private static final String MOUSE_DESC="mousedesc";
    private static final String KEYBOARD_DESC="keyboarddesc";

    private static final String OFFICE="office";
    private static final String UTILITIES="utilities";
    private static final String CREATORS="creators";
    private static final String PRO="pro";
    private static final String DEV="dev";
    private static final String BOMBS="bombs";

    private static final String MESSAGE="message";
    @SuppressLint("CommitPrefEdits")
    public PrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void saveEmail(String email){
        editor.putString(EMAIL,email);
        editor.commit();
    }
    public void saveMonitorPrice(String price){
        editor.putString(MONITOR_PRICE,price);
        editor.commit();
    }
    public void saveKeyboardPrice(String price){
        editor.putString(KEYBOARD_PRICE,price);
        editor.commit();
    }
    public void saveMousePrice(String price){
        editor.putString(MOUSE_PRICE,price);
        editor.commit();
    }
    public void saveCPUPrice(String price){
        editor.putString(CPU_PRICE,price);
        editor.commit();
    }
    public void saveGPUPrice(String price){
        editor.putString(GPU_PRICE,price);
        editor.commit();
    }
    public void saveRAMPrice(String price){
        editor.putString(RAM_PRICE,price);
        editor.commit();
    }
    public void saveMotherboardPrice(String price){
        editor.putString(MB_PRICE,price);
        editor.commit();
    }
    public  void saveCabinetPrice(String price){
        editor.putString(CABINET_PRICE,price);
        editor.commit();
    }
    public  void saveSSDPrice(String price){
        editor.putString(SSD_PRICE,price);
        editor.commit();
    }
    public  void saveHDDPrice(String price){
        editor.putString(HDD_PRICE,price);
        editor.commit();
    }
    public void savePSUPrice(String price){
        editor.putString(PSU_PRICE,price);
        editor.commit();
    }
    public void saveCoolerPrice(String price){
        editor.putString(COOLER_PRICE,price);
        editor.commit();
    }

    public void saveMonitorModel(String model){
        editor.putString(MONITOR_MODEL,model);
        editor.commit();
    }
    public void saveMouseModel(String model){
        editor.putString(MOUSE_MODEL,model);
        editor.commit();
    }
    public void saveKeyboardModel(String model){
        editor.putString(KEYBOARD_MODEL,model);
        editor.commit();
    }
    public void saveCPUModel(String model){
        editor.putString(CPU_MODEL,model);
        editor.commit();
    }
    public  void saveGPUModel(String model){
        editor.putString(GPU_MODEL,model);
        editor.commit();
    }
    public void saveRAMModel(String model){
        editor.putString(RAM_MODEL,model);
        editor.commit();
    }
    public void saveMotherboardModel(String model){
        editor.putString(MB_MODEL,model);
        editor.commit();
    }
    public void saveCabinetModel(String model){
        editor.putString(CABINET_MODEL,model);
        editor.commit();
    }
    public void saveSSDModel(String model){
        editor.putString(SSD_MODEL,model);
        editor.commit();
    }
    public void saveHDDModel(String model){
        editor.putString(HDD_MODEL,model);
        editor.commit();
    }
    public void savePSUModel(String model){
        editor.putString(PSU_MODEL,model);
        editor.commit();
    }
    public void saveCoolerModel(String model){
        editor.putString(COOLER_MODEL,model);
        editor.commit();
    }

    public void saveMonitorDesc(String desc){
        editor.putString(MONITOR_DESC,desc);
        editor.commit();
    }
    public void saveMouseDesc(String desc){
        editor.putString(MOUSE_DESC,desc);
        editor.commit();
    }
    public void saveKeyboardDesc(String desc){
        editor.putString(KEYBOARD_DESC,desc);
        editor.commit();
    }
    public void saveCPUDesc(String desc){
        editor.putString(CPU_DESC,desc);
        editor.commit();
    }
    public  void saveGPUDesc(String desc){
        editor.putString(GPU_DESC,desc);
        editor.commit();
    }
    public void saveRAMDesc(String desc){
        editor.putString(RAM_DESC,desc);
        editor.commit();
    }
    public void saveMotherboardDesc(String desc){
        editor.putString(MB_DESC,desc);
        editor.commit();
    }
    public void saveCabinetDesc(String desc){
        editor.putString(CABINET_DESC,desc);
        editor.commit();
    }
    public void saveSSDDesc(String desc){
        editor.putString(SSD_DESC,desc);
        editor.commit();
    }
    public void saveHDDDesc(String desc){
        editor.putString(HDD_DESC,desc);
        editor.commit();
    }
    public void savePSUDesc(String desc){
        editor.putString(PSU_DESC,desc);
        editor.commit();
    }
    public void saveCoolerDesc(String desc){
        editor.putString(COOLER_DESC,desc);
        editor.commit();
    }

    public void saveCategory(String category){
        editor.putString(KEY_CATEGORY,category);
        editor.commit();
    }
    public void saveFinalAmount(String amount){
        editor.putString(KEY_AMOUNT,amount);
        editor.commit();
    }

    public void saveSSDCategory(String category){
        editor.putString(KEY_SSD,category);
        editor.commit();
    }
    public void saveRAMCategory(String category){
        editor.putString(KEY_RAM,category);
        editor.commit();
    }
    public void saveBreed(String breed) {
        editor.putString(KEY_BREED,breed);
        editor.commit();
    }
    public void saveBudget(int budget){
        editor.putInt(KEY_BUDGET,budget);
        editor.commit();
    }
    public void saveOffice(String office){
        editor.putString(OFFICE,office);
        editor.commit();
    }
    public void saveUtilities(String utilities){
        editor.putString(UTILITIES,utilities);
        editor.commit();
    }
    public void saveCreator(String creators){
        editor.putString(CREATORS,creators);
        editor.commit();
    }
    public void savePro(String pro){
        editor.putString(PRO,pro);
        editor.commit();
    }
    public void saveDev(String dev){
        editor.putString(DEV,dev);
        editor.commit();
    }
    public void saveMessage(String message){
        editor.putString(MESSAGE,message);
        editor.commit();
    }
    public String getMessage(){
        return sharedPreferences.getString(MESSAGE,"");
    }
    public void saveBombs(String bombs){
        editor.putString(BOMBS,bombs);
        editor.commit();
    }
    public String getOffice(){
        return sharedPreferences.getString(OFFICE,"");
    }
    public String getUtilities(){
        return sharedPreferences.getString(UTILITIES,"");
    }
    public String getCreator(){
        return sharedPreferences.getString(CREATORS,"");
    }
    public String getPro(){
        return sharedPreferences.getString(PRO,"");
    }
    public String getDev(){
        return sharedPreferences.getString(DEV,"");
    }
    public String getBombs(){
        return sharedPreferences.getString(BOMBS,"");
    }
    public String getCategory(){
        return sharedPreferences.getString(KEY_CATEGORY,"");
    }
    public String getSSDCategory(){
        return sharedPreferences.getString(KEY_SSD,"");
    }
    public String getRAMCategory(){
        return sharedPreferences.getString(KEY_RAM,"");
    }
    public String getBreed(){
        return sharedPreferences.getString(KEY_BREED,"");
    }
    public int getBudget(){
        return sharedPreferences.getInt(KEY_BUDGET,0);
    }
    public String getMonitorModel(){
        return sharedPreferences.getString(MONITOR_MODEL,"");
    }
    public String getMouseModel(){
        return sharedPreferences.getString(MOUSE_MODEL,"");
    }
    public String getKeyboardModel(){
        return sharedPreferences.getString(KEYBOARD_MODEL,"");
    }
    public String getCPUModel(){
        return sharedPreferences.getString(CPU_MODEL,"");
    }
    public String getGpuModel(){
        return sharedPreferences.getString(GPU_MODEL,"");
    }
    public String getRAMModel(){
        return sharedPreferences.getString(RAM_MODEL,"");
    }
    public String getMotherboardModel(){
        return sharedPreferences.getString(MB_MODEL,"");
    }
    public String getCabinetModel(){
        return sharedPreferences.getString(CABINET_MODEL,"");
    }
    public String getSSDModel(){
        return sharedPreferences.getString(SSD_MODEL,"");
    }
    public String getHDDModel(){
        return sharedPreferences.getString(HDD_MODEL,"");
    }
    public String getPSUModel(){
        return sharedPreferences.getString(PSU_MODEL,"");
    }
    public String getCoolerModel(){
        return sharedPreferences.getString(COOLER_MODEL,"");
    }

    public String getCPUPrice(){
        return sharedPreferences.getString(CPU_PRICE,"");
    }
    public String getGPUPrice(){
        return sharedPreferences.getString(GPU_PRICE,"");
    }
    public String getRAMPrice(){
        return sharedPreferences.getString(RAM_PRICE,"");
    }
    public String getMotherboardPrice(){
        return sharedPreferences.getString(MB_PRICE,"");
    }
    public String getCabinetPrice(){
        return sharedPreferences.getString(CABINET_PRICE,"");
    }
    public String getSSDPrice(){
        return sharedPreferences.getString(SSD_PRICE,"");
    }
    public String getHDDPrice(){
        return sharedPreferences.getString(HDD_PRICE,"");
    }
    public String getPSUPrice(){
        return sharedPreferences.getString(PSU_PRICE,"");
    }
    public String getCoolerPrice(){
        return sharedPreferences.getString(COOLER_PRICE,"");
    }
    public String getMonitorPrice(){
        return sharedPreferences.getString(MONITOR_PRICE,"");
    }
    public String getMousePrice(){
        return sharedPreferences.getString(MOUSE_PRICE,"");
    }
    public String getKeyboardPrice(){
        return sharedPreferences.getString(KEYBOARD_PRICE,"");
    }

    public String getCPUDesc(){
        return sharedPreferences.getString(CPU_DESC,"");
    }
    public String getGPUDesc(){
        return sharedPreferences.getString(GPU_DESC,"");
    }
    public String getRAMDesc(){
        return sharedPreferences.getString(RAM_DESC,"");
    }
    public String getMotherboardDesc(){
        return sharedPreferences.getString(MB_DESC,"");
    }
    public String getCabinetDesc(){
        return sharedPreferences.getString(CABINET_DESC,"");
    }
    public String getSSDDesc(){
        return sharedPreferences.getString(SSD_DESC,"");
    }
    public String getHDDDesc(){
        return sharedPreferences.getString(HDD_DESC,"");
    }
    public String getPSUDesc(){
        return sharedPreferences.getString(PSU_DESC,"");
    }
    public String getCoolerDesc(){
        return sharedPreferences.getString(COOLER_DESC,"");
    }
    public String getMonitorDesc(){
        return sharedPreferences.getString(MONITOR_DESC,"");
    }
    public String getMouseDesc(){
        return sharedPreferences.getString(MOUSE_DESC,"");
    }
    public String getKeyboardDesc(){
        return sharedPreferences.getString(KEYBOARD_DESC,"");
    }

    public String getFinalAmount(){
        return sharedPreferences.getString(KEY_AMOUNT,"");
    }
    public String getEmail(){
        return sharedPreferences.getString(EMAIL,"");
    }
}
