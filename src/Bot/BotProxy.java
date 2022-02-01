package Bot;

import com.snowygryphon.osrs.script.*;
import com.snowygryphon.osrs.script.ge.GrandExchange;
import com.snowygryphon.osrs.script.ui.RuntimeUI;
import org.joml.Vector2i;

import java.util.ArrayList;
import java.util.Random;

//TODO: WIP
public class BotProxy {
    private Bot BOT;
    private long LAST_INTERACTION_TIME;
    private WorldObject LAST_INTERACTION_OBJECT;

    public BotProxy(Bot BOT) {
        this.BOT = BOT;
    }

    
    public BotConfig getBotConfig() {
        return BOT.getBotConfig();
    }

    private void setLastInteractionTime()
    {
        LAST_INTERACTION_TIME = System.currentTimeMillis();
    }

    public long getLastInteractionTime(){
        return LAST_INTERACTION_TIME;
    }
    
    public void interactWith(WorldObject worldObject, String s) {
        setLastInteractionTime();
        //todo: set last interacted object
        BOT.interactWith(worldObject, s);
    }

    
    public void interactWith(WorldObject worldObject, int i, String s) {
        setLastInteractionTime();
        BOT.interactWith(worldObject, i, s);
    }

    
    public void interactWith(InventoryItem inventoryItem, int i, String s, String s1) {
        setLastInteractionTime();
    }

    
    public void interactWith(InventoryItem inventoryItem, int i, String s) {
        setLastInteractionTime();
    }

    
    public void interactWith(InventoryItem inventoryItem, ItemAction itemAction) {
        setLastInteractionTime();
    }

    
    public void interactWith(InventoryItem inventoryItem, String s) {
        setLastInteractionTime();
    }

    
    public void interactWith(InventoryItem inventoryItem, int i) {
        setLastInteractionTime();
    }

    
    public void interactWith(Widget widget, String s) {
        setLastInteractionTime();
    }

    
    public void interactWith(Widget widget) {
        setLastInteractionTime();
    }

    
    public void interactWith(BankItem bankItem, String s) {
        setLastInteractionTime();
    }

    
    public void interactWith(BankItem bankItem) {
        setLastInteractionTime();
    }

    
    public void tap(Vector2i vector2i) {

    }

    
    public void swipe(Vector2i vector2i, Vector2i vector2i1) {

    }

    
    public void sendKeyCode(MobileKeyCode mobileKeyCode) {

    }

    
    public void enterText(String s) {

    }

    
    public boolean walkToTileOnMiniMap(Vector2i vector2i) {
        return false;
    }

    
    public boolean walkTowardsTileOnMinimap(Vector2i vector2i) {
        return false;
    }

    
    public void refocus() {

    }

    
    public Chat getChat() {
        return null;
    }

    
    public GrandExchange getGrandExchange() {
        return null;
    }

    
    public Random getRandom() {
        return null;
    }

    
    public void log(LogSeverity logSeverity, String s) {

    }

    
    public void logInfo(String s) {

    }

    
    public void logWarning(String s) {

    }

    
    public void logError(String s) {

    }

    
    public void logSuccess(String s) {

    }

    
    public void sleep(int i) {

    }

    
    public boolean doUntil(int i, Bot.IsCompletedCallback isCompletedCallback, Runnable runnable) {
        return false;
    }

    
    public boolean sleepUntil(int i, Bot.IsCompletedCallback isCompletedCallback) {
        return false;
    }

    
    public ArrayList<Integer> getInventoryActionLog() {
        return null;
    }

    
    public ArrayList<Integer> getActionLog() {
        return null;
    }

    
    public WorldSwitcher getWorldSwitcher() {
        return null;
    }

    
    public void stop() {

    }

    
    public BotSettingsStore getBotSettings() {
        return null;
    }

    
    public boolean isBotRunning() {
        return false;
    }

    
    public PathCalculator getPathCalculator() {
        return null;
    }

    
    public WebWalker getWebWalker() {
        return null;
    }

    
    public boolean webWalkTo(WorldPos worldPos) {
        return false;
    }

    
    public boolean webWalkTo(BankLocation bankLocation) {
        return false;
    }

    
    public EnergyManager getEnergyManager() {
        return null;
    }

    
    public GenericSettingsHandler getGenericSettingsHandler() {
        return null;
    }

    
    public RuntimeUI getRuntimeUI() {
        return null;
    }

    
    public void selectDialogOption(int i) {

    }

    
    public void clickLoginButton() {

    }

    
    public void clickDisconnectedOKButton() {

    }

    
    public int[] getVarBits() {
        return new int[0];
    }

    
    public ConnectionState getConnectionState() {
        return null;
    }

    
    public void continueDialog() {

    }

    
    public Camera getCamera() {
        return null;
    }

    
    public LocalPlayer getLocalPlayer() {
        return null;
    }

    
    public WorldObjects<Player> getPlayers() {
        return null;
    }

    
    public WorldObjects<GroundObject> getGroundObjects() {
        return null;
    }

    
    public GameObjects getGameObjects() {
        return null;
    }

    
    public WorldObjects<NPC> getNPCs() {
        return null;
    }

    
    public Widget getRootWidget() {
        return null;
    }

    
    public StdWindows getStdWindows() {
        return null;
    }

    
    public InventoryWindow getInventory() {
        return null;
    }

    
    public BankWindow getBank() {
        return null;
    }

    
    public EquipmentWindow getEquipment() {
        return null;
    }

    
    public SpellsWindow getSpells() {
        return null;
    }

    
    public PrayerWindow getPrayer() {
        return null;
    }

    
    public boolean isLoggedIn() {
        return false;
    }

    
    public boolean isGameRunning() {
        return false;
    }

    
    public int getGlobalXOffset() {
        return 0;
    }

    
    public int getGlobalYOffset() {
        return 0;
    }

    
    public void updateData() {

    }

    
    public String getInstallationDir() {
        return null;
    }
}
