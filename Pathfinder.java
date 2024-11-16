import java.util.*;

public class Pathfinder {

    static class State {
        double x, y;
        int direction;
        int moves;
        int visitedMask;
        List<String> path;

        public State(double x, double y, int direction, int moves, int visitedMask, List<String> path) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.moves = moves;
            this.visitedMask = visitedMask;
            this.path = new ArrayList<>(path);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, direction, visitedMask);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            State state = (State) obj;
            return Double.compare(state.x, x) == 0 &&
                   Double.compare(state.y, y) == 0 &&
                   direction == state.direction &&
                   visitedMask == state.visitedMask;
        }
    }

    private static final int[][] DIRECTIONS = {
        {0, 1},  // +y
        {1, 0},  // +x
        {0, -1}, // -y
        {-1, 0}  // -x
    };

    public static void findPath(double startX, double startY, List<double[]> points) {
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        int allPointsMask = (1 << points.size()) - 1; // Binary mask for all points
        State startState = new State(startX, startY, 0, 0, 0, new ArrayList<>());
        queue.add(startState);
        visited.add(startState);

        while (!queue.isEmpty()) {
            State current = queue.poll();

            // Check if we've touched all points
            if (current.visitedMask == allPointsMask) {
                System.out.println("Start: (" + startX + ", " + startY + ")");
                System.out.println("All points touched.");
                System.out.println("Total moves: " + current.moves);
                System.out.println("Directions:");
                for (String step : current.path) {
                    System.out.println(step);
                }
                return;
            }

            // Move forward
            double newX = current.x + DIRECTIONS[current.direction][0];
            double newY = current.y + DIRECTIONS[current.direction][1];
            int newVisitedMask = current.visitedMask;
            List<String> newPath = new ArrayList<>(current.path);
            newPath.add("move forward");

            // Check if moving forward touches any points
            for (int i = 0; i < points.size(); i++) {
                if ((newVisitedMask & (1 << i)) == 0) { // Point not yet touched
                    double[] point = points.get(i);
                    if (Math.abs(newX - point[0]) < 1e-6 && Math.abs(newY - point[1]) < 1e-6) {
                        newVisitedMask |= (1 << i); // Mark this point as touched
                    }
                }
            }

            State moveForwardState = new State(newX, newY, current.direction, current.moves + 1, newVisitedMask, newPath);
            if (!visited.contains(moveForwardState)) {
                queue.add(moveForwardState);
                visited.add(moveForwardState);
            }

            // Turn clockwise
            int newDirection = (current.direction + 1) % 4;
            State turnClockwiseState = new State(current.x, current.y, newDirection, current.moves + 1, current.visitedMask, current.path);
            turnClockwiseState.path.add("turn clockwise");

            if (!visited.contains(turnClockwiseState)) {
                queue.add(turnClockwiseState);
                visited.add(turnClockwiseState);
            }

            // Repeat: Try moving forward multiple steps in the same direction
            for (int repeatCount = 2; repeatCount <= 5; repeatCount++) {
                newX = current.x + DIRECTIONS[current.direction][0] * repeatCount;
                newY = current.y + DIRECTIONS[current.direction][1] * repeatCount;
                newPath = new ArrayList<>(current.path);
                newPath.add("repeat " + repeatCount + " times");
                newPath.add("  move forward");
                newVisitedMask = current.visitedMask;

                // Check if any point is touched within this repeated move
                for (int i = 0; i < points.size(); i++) {
                    if ((newVisitedMask & (1 << i)) == 0) {
                        double[] point = points.get(i);
                        if (Math.abs(newX - point[0]) < 1e-6 && Math.abs(newY - point[1]) < 1e-6) {
                            newVisitedMask |= (1 << i);
                        }
                    }
                }

                State repeatState = new State(newX, newY, current.direction, current.moves + 1, newVisitedMask, newPath);
                if (!visited.contains(repeatState)) {
                    queue.add(repeatState);
                    visited.add(repeatState);
                }
            }
        }

        System.out.println("No path found that touches all points.");
    }

    public static void main(String[] args) {
        // Example usage
        double startX = 0, startY = 0;
        List<double[]> points = Arrays.asList(
            new double[]{1, 1}, new double[]{2, 2}, new double[]{3, 3}
        );
        
        findPath(startX, startY, points);
    }
}
