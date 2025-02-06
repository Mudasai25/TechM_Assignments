package Sample;
import java.util.Scanner;

	class Player {
	    private int playerId;
	    private String skill;
	    private String level;
	    private int points;

	    public Player(int playerId, String skill, String level, int points) {
	        this.playerId = playerId;
	        this.skill = skill;
	        this.level = level;
	        this.points = points;
	    }

	    public int getPlayerId() {
	        return playerId;
	    }

	    public String getSkill() {
	        return skill;
	    }

	    public String getLevel() {
	        return level;
	    }

	    public int getPoints() {
	        return points;
	    }
	}

	public class Assign_Player {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Player[] players = new Player[4];

	        for (int i = 0; i < 4; i++) {
	            int playerId = Integer.parseInt(scanner.nextLine());
	            String skill = scanner.nextLine();
	            String level = scanner.nextLine();
	            int points = Integer.parseInt(scanner.nextLine());
	            players[i] = new Player(playerId, skill, level, points);
	        }
	        
	        String skill = scanner.nextLine();
	        String level = scanner.nextLine();
	        scanner.close();

	        int totalPoints = findPointsForGivenSkill(players, skill);
	        if (totalPoints > 0) {
	            System.out.println(totalPoints);
	        } else {
	            System.out.println("The given Skill is not available");
	        }

	        Player player = getPlayerBasedOnLevel(players, level, skill);
	        if (player != null) {
	            System.out.println(player.getPlayerId());
	        } else {
	            System.out.println("No player is available with specified level, skill and eligibility points");
	        }
	    }

	    public static int findPointsForGivenSkill(Player[] players, String skill) {
	        int totalPoints = 0;
	        for (Player player : players) {
	            if (player.getSkill().equalsIgnoreCase(skill)) {
	                totalPoints += player.getPoints();
	            }
	        }
	        return totalPoints;
	    }

	    public static Player getPlayerBasedOnLevel(Player[] players, String level, String skill) {
	        for (Player player : players) {
	            if (player.getSkill().equalsIgnoreCase(skill) && player.getLevel().equalsIgnoreCase(level) && player.getPoints() >= 20) {
	                return player;
	            }
	        }
	        return null;
	    }
	}

