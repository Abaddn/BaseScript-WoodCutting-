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
