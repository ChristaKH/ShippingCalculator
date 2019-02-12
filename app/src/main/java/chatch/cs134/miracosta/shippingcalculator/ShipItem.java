/**
 * This ShipItem class takes in info on package weight
 * and the base cost to ship and performs calculations
 * to give a total shipping cost
 *
 * @author  Christa Hatch
 */
package chatch.cs134.miracosta.shippingcalculator;

public class ShipItem
{
    public static final double ADDED_COST = 0.50;
    private double weight;
    private double baseCost;
    private double addedCost;
    private double totalCost;

    /** Initializes ShipItem and sets weight to 0, addedCost to 0.0, and baseCost at the
     * base price of $3, then calculates the totalCosts
     */
    public ShipItem()
    {
        weight = 0.0;
        baseCost = 3.0;
        addedCost = 0.0;
        totalCost = this.calcCost();
    }

    /** Initializes ShipItem and sets weight to the value of initialWeight and baseCost at the
     * the value of initialBaseCost, then calculates the totalCosts and addedCost
     * @param initialWeight The initial weight of the package
     * @param initialBaseCost The initial base cost for shipping a package of 16 ounces or less
     */
    public ShipItem( double initialWeight, double initialBaseCost )
    {
        this.setWeight(initialWeight);
        this.setBaseCost(initialBaseCost);
        this.calcAddedCost();
        this.calcCost();
    }

    /** Sets the value of weight to the absolute value of new Weigh (no negative costs!)
     * and then updates the value of totalCost and addedCost
     * @param newWeight the new value of weight. It will be check to make sure that the
     *                  weight is not in the negatives
     */
    public void setWeight( double newWeight )
    {
        if( newWeight < 0 )
        {
            newWeight *= -1;
        }

        weight = newWeight;
        this.calcAddedCost();
        this.calcCost();
    }

    /** Sets the value of the base cost to ship a package to the absolute value of the
     * newBase.
     * @param newBase new value of base cost to ship before it is checked so that the base
     *                cost isn't negative
     */
    public void setBaseCost( double newBase )
    {
        if( newBase < 0 )
        {
            newBase *= -1;
        }

        baseCost = newBase;
        this.calcAddedCost();
        this.calcCost();
    }

    /** Returns the weight of the package
     *
     * @return the weight of the package
     */
    public double getWeight()
    {
        return weight;
    }

    /** Returns the base cost to ship a package
     *
     * @return the base cost to ship
     */
    public double getBaseCost()
    {
        return baseCost;
    }

    /** Calculates the added cost to the base cost based off of the weight
     *
     * @return new added cost
     */
    public double calcAddedCost()
    {
        if( weight > 16 )
        {
            addedCost = ( (16 - weight)/4) * ADDED_COST;
        }

        return addedCost;
    }

    /** Method to calculate the total cost to ship a package and
     * return that value.
     *
     * @return the total cost of shipping
     */
    public double calcCost()
    {
        totalCost = baseCost + addedCost;

        return totalCost;
    }
}
