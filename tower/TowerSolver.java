package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        // Call the missing solve method (not this one)
        solve(model.height(), 0, 2, 1);
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    //
    // Recursive method to solve Tower of Hanoi
    private void solve(int height, int source, int destination, int auxiliary)
    {
        // Base case
        if (height == 1)
        {
            model.move(source, destination);
            return;
        }
        solve(height - 1, source, auxiliary, destination);
        model.move(source, destination);
        solve(height - 1, auxiliary, destination, source);
    }

}
