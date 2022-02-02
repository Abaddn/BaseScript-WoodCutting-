package Bot;

import com.snowygryphon.osrs.script.*;
import com.snowygryphon.osrs.script.ge.GrandExchange;
import com.snowygryphon.osrs.script.ui.RuntimeUI;
import org.joml.Vector2i;

import java.util.ArrayList;
import java.util.Random;

public class BotProxy {
    private Bot BOT;
    private long LAST_INTERACTION_TIME;
    private WorldObject LAST_INTERACTION_OBJECT;
    private Item LAST_INTERACTION_ITEM;
    private Widget LAST_INTERACTION_WIDGET;

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
    private void setLastInteractionItem(Item item)
    {
        LAST_INTERACTION_ITEM = item;
    }
    private void setLastInteractionObject(WorldObject object)
    {
        LAST_INTERACTION_OBJECT = object;
    }
    private void setLastInteractionWidget(Widget widget)
    {
        LAST_INTERACTION_WIDGET = widget;
    }

    public long getLastInteractionTime(){
        return LAST_INTERACTION_TIME;
    }
    
    public void interactWith(WorldObject worldObject, String s) {
        setLastInteractionTime();
        setLastInteractionObject(worldObject);
        BOT.interactWith(worldObject, s);
    }

    
    public void interactWith(WorldObject worldObject, int i, String s) {
        setLastInteractionTime();
        setLastInteractionObject(worldObject);
        BOT.interactWith(worldObject, i, s);
    }

    
    public void interactWith(InventoryItem inventoryItem, int i, String s, String s1) {
        setLastInteractionItem(inventoryItem);
        setLastInteractionTime();
        BOT.interactWith(inventoryItem, i, s, s1);
    }

    
    public void interactWith(InventoryItem inventoryItem, int i, String s) {
        setLastInteractionItem(inventoryItem);
        setLastInteractionTime();
        BOT.interactWith(inventoryItem, i, s);
    }

    
    public void interactWith(InventoryItem inventoryItem, ItemAction itemAction) {
        setLastInteractionItem(inventoryItem);
        setLastInteractionTime();
        BOT.interactWith(inventoryItem, itemAction);
    }

    
    public void interactWith(InventoryItem inventoryItem, String s) {
        setLastInteractionItem(inventoryItem);
        setLastInteractionTime();
        BOT.interactWith(inventoryItem, s);
    }

    
    public void interactWith(InventoryItem inventoryItem, int i) {
        setLastInteractionItem(inventoryItem);
        setLastInteractionTime();
        BOT.interactWith(inventoryItem, i);
    }

    
    public void interactWith(Widget widget, String s) {
        setLastInteractionWidget(widget);
        setLastInteractionTime();
        BOT.interactWith(widget, s);
    }

    
    public void interactWith(Widget widget) {

        setLastInteractionWidget(widget);
        setLastInteractionTime();
        BOT.interactWith(widget);
    }

    
    public void interactWith(BankItem bankItem, String s) {

        setLastInteractionItem(bankItem);
        setLastInteractionTime();
        BOT.interactWith(bankItem, s);
    }

    
    public void interactWith(BankItem bankItem) {
        setLastInteractionItem(bankItem);
        setLastInteractionTime();
        BOT.interactWith(bankItem);
    }

    
    public void tap(Vector2i vector2i) {
        BOT.tap(vector2i);
    }

    
    public void swipe(Vector2i start, Vector2i end) {
        BOT.swipe(start, end);
    }

    public void sendKeyCode(MobileKeyCode mobileKeyCode) {
        BOT.sendKeyCode(mobileKeyCode);
    }

    public void enterText(String s) {
        BOT.enterText(s);
    }

    public boolean walkToTileOnMiniMap(Vector2i tile) {
        return BOT.walkToTileOnMiniMap(tile);
    }
    
    public boolean walkTowardsTileOnMinimap(Vector2i tile) {
        return BOT.walkTowardsTileOnMinimap(tile);
    }

    public void refocus() {
        BOT.refocus();
    }

    public Chat getChat() {
        return BOT.getChat();
    }
    
    public GrandExchange getGrandExchange() {
        return BOT.getGrandExchange();
    }

    public Random getRandom() {
        return BOT.getRandom();
    }
    
    public void log(LogSeverity logSeverity, String s) {
        BOT.log(logSeverity, s);
    }

    public void logInfo(String s) {
        BOT.logInfo(s);
    }

    
    public void logWarning(String s) {
        BOT.logWarning(s);
    }
    
    public void logError(String s) {
        BOT.logError(s);
    }
    
    public void logSuccess(String s) {
        BOT.logSuccess(s);
    }

    public void sleep(int i) {
        BOT.sleep(i);
    }

    public boolean doUntil(int i, Bot.IsCompletedCallback isCompletedCallback, Runnable runnable) {
        return BOT.doUntil(i, isCompletedCallback, runnable);
    }

    public boolean sleepUntil(int i, Bot.IsCompletedCallback isCompletedCallback) {
        return BOT.sleepUntil(i, isCompletedCallback);
    }

    public ArrayList<Integer> getInventoryActionLog() {
        return BOT.getInventoryActionLog();
    }
    
    public ArrayList<Integer> getActionLog() {
        return BOT.getActionLog();
    }
    
    public WorldSwitcher getWorldSwitcher() {
        return BOT.getWorldSwitcher();
    }
    
    public void stop() {
        BOT.stop();
    }
    
    public BotSettingsStore getBotSettings() {
        return BOT.getBotSettings();
    }
    
    public boolean isBotRunning() {
        return BOT.isBotRunning();
    }
    
    public PathCalculator getPathCalculator() {
        return BOT.getPathCalculator();
    }
    
    public WebWalker getWebWalker() {
        return BOT.getWebWalker();
    }
    
    public boolean webWalkTo(WorldPos worldPos) {
        return BOT.webWalkTo(worldPos);
    }
    
    public boolean webWalkTo(BankLocation bankLocation) {
        return BOT.webWalkTo(bankLocation);
    }

    public EnergyManager getEnergyManager() {
        return BOT.getEnergyManager();
    }

    public GenericSettingsHandler getGenericSettingsHandler() {
        return BOT.getGenericSettingsHandler();
    }
    
    public RuntimeUI getRuntimeUI() {
        return BOT.getRuntimeUI();
    }

    public void selectDialogOption(int i) {
        BOT.selectDialogOption(i);
    }
    
    public void clickLoginButton() {
        BOT.clickLoginButton();
    }
    
    public void clickDisconnectedOKButton() {
        BOT.clickDisconnectedOKButton();
    }

    public int[] getVarBits() {
        return BOT.getVarBits();
    }

    public ConnectionState getConnectionState() {
        return BOT.getConnectionState();
    }

    public void continueDialog() {
        BOT.continueDialog();
    }

    public Camera getCamera() {
        return BOT.getCamera();
    }

    public LocalPlayer getLocalPlayer() {
        return BOT.getLocalPlayer();
    }
    
    public WorldObjects<Player> getPlayers() {
        return BOT.getPlayers();
    }
    
    public WorldObjects<GroundObject> getGroundObjects() {
        return BOT.getGroundObjects();
    }
    
    public GameObjects getGameObjects() {
        return BOT.getGameObjects();
    }
    
    public WorldObjects<NPC> getNPCs() {
        return BOT.getNPCs();
    }
    
    public Widget getRootWidget() {
        return BOT.getRootWidget();
    }
    
    public StdWindows getStdWindows() {
        return BOT.getStdWindows();
    }
    
    public InventoryWindow getInventory() {
        return BOT.getInventory();
    }
    
    public BankWindow getBank() {
        return BOT.getBank();
    }
    
    public EquipmentWindow getEquipment() {
        return BOT.getEquipment();
    }
    
    public SpellsWindow getSpells() {
        return BOT.getSpells();
    }
    
    public PrayerWindow getPrayer() {
        return BOT.getPrayer();
    }
    
    public boolean isLoggedIn() {
        return BOT.isLoggedIn();
    }
    
    public boolean isGameRunning() {
        return BOT.isGameRunning();
    }
    
    public int getGlobalXOffset() {
        return BOT.getGlobalXOffset();
    }
    
    public int getGlobalYOffset() {
        return BOT.getGlobalYOffset();
    }
    
    public void updateData() {
        BOT.updateData();
    }
    
    public String getInstallationDir() {
        return BOT.getInstallationDir();
    }
}
