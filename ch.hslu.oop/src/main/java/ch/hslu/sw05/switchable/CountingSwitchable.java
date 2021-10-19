package ch.hslu.sw05.switchable;

public abstract class CountingSwitchable implements Switchable {
    private long switchCount;
    
    protected CountingSwitchable() {
        this.switchCount = 0;
    }
    
    @Override
    public void switchOn() {
        this.switchCount++;
    }
    
    @Override
    public void switchOff() {
        this.switchCount++;
    }
    
    public long getSwitchCount() {
        return this.switchCount;
    }
}