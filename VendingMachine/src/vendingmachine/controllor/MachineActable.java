package vendingmachine.controllor;

public interface MachineActable {
	public void inputCoin();

	public void returnCoin();

	public void registerProduct();

	public void deleteProduct();

	public void reviseProduct();

	public void showProducts();

	public void pickProduct();
}
