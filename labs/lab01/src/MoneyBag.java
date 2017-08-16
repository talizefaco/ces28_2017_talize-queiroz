import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class	MoneyBag	implements MoneyInterface{
	private LinkedHashMap<Currency, Money> _mBag; 
	public	MoneyBag()	{
		_mBag = new LinkedHashMap<Currency, Money>();
	}
	
	public LinkedHashMap <Currency, Money> getmBag(){
		return this._mBag;
	}

	public void add(Money m) {
		if (_mBag.containsKey(m.getCurrency()) ){
           Money auxiliar = new Money(m.getAmount() + _mBag.get(m.getCurrency()).getAmount(),m.getCurrency());
           _mBag.put(m.getCurrency(), auxiliar);
        }
		else{
			_mBag.put(m.getCurrency(),m);	
		}
	}
	
	public String showMoney() {
		String str = "";
		for (Entry<Currency, Money> entry : this._mBag.entrySet()) {
		    str += entry.getValue().stringMoney();
		}
		return str;
	}
	
	public int convertToBRL() {
		int valueBRL =0;
		for (Entry<Currency, Money> entry : this._mBag.entrySet()) {
		    valueBRL += entry.getValue().convertMoney();
		}
		return valueBRL;
	}
	
}