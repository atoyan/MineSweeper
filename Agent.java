package com.mine.sweeper;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;

public class Agent {

	private static Random randomizer = new Random();

	public static Hashtable<String, Hashtable<String, String>> antallaghGnwshs(
			int linesOfField, int columnsOfField, int i, int j, String field,
			Hashtable<String, String> lab,
			Hashtable<String, Hashtable<String, String>> knowledge) {

		if (knowledge == null)
			knowledge = new Hashtable<String, Hashtable<String, String>>();
		Hashtable<String, String> tmpKnowledge = knowledge.get(field);
		if (null == tmpKnowledge)
			tmpKnowledge = new Hashtable<String, String>();

		tmpKnowledge.put(i + "_" + j, " ");
		int upI = i - 1;
		int upJ = j;
		int rightI = i;
		int rightJ = j + 1;
		int downI = i + 1;
		int downJ = j;
		int leftI = i;
		int leftJ = j - 1;
		if (lab.get(upI + "_" + upJ) != null)
			tmpKnowledge
					.put(upI + "_" + upJ, lab.get(upI + "_" + upJ));
		if (lab.get(downI + "_" + downJ) != null)
			tmpKnowledge.put(downI + "_" + downJ, lab.get(downI + "_"
					+ downJ));
		if (lab.get(rightI + "_" + rightJ) != null)
			tmpKnowledge.put(rightI + "_" + rightJ, lab.get(rightI
					+ "_" + rightJ));
		if (lab.get(leftI + "_" + leftJ) != null)
			tmpKnowledge.put(leftI + "_" + leftJ, lab.get(leftI + "_"
					+ leftJ));

		if (tmpKnowledge.containsValue("B")
				&& (lab.get(upI + "_" + upJ).equalsIgnoreCase("A")
						|| lab.get(downI + "_" + downJ)
								.equalsIgnoreCase("A")
						|| lab.get(leftI + "_" + leftJ)
								.equalsIgnoreCase("A") || lab.get(
						rightI + "_" + rightJ).equalsIgnoreCase("A"))) {
			knowledge.get("A").putAll(tmpKnowledge);
			return knowledge;
		}

		String adjField = "";
		int agentchecker = -1;
		Hashtable<String, String> adjKnowledge = null;
		if (i < linesOfField - 1) {
			int tt = i + 1;
			int ss = j + 1;

			adjField = lab.get(tt + "_" + j);
			agentchecker = -1;
			try {
				agentchecker = Integer.parseInt(adjField);
			} catch (Exception e) {
				// do nothing leave -1
			}
			if (adjField.equalsIgnoreCase("A") || agentchecker > 0) {
				tmpKnowledge.put(tt + "_" + j, " ");
				adjKnowledge = knowledge.get(adjField);
				if (null != adjKnowledge && !adjKnowledge.isEmpty())
					tmpKnowledge.putAll(adjKnowledge);
			} else {
				tmpKnowledge.put(tt + "_" + j, lab.get(tt + "_" + j));
			}
			if (j < columnsOfField - 1) {
				adjField = lab.get(tt + "_" + ss);
				agentchecker = -1;
				try {
					agentchecker = Integer.parseInt(adjField);
				} catch (Exception e) {
					// do nothing leave -1
				}
				if (adjField.equalsIgnoreCase("A") || agentchecker > 0) {
					tmpKnowledge.put(tt + "_" + ss, " ");
					adjKnowledge = knowledge.get(adjField);
					if (null != adjKnowledge && !adjKnowledge.isEmpty())
						tmpKnowledge.putAll(adjKnowledge);
				} else {
					tmpKnowledge.put(tt + "_" + ss, lab.get(tt + "_"
							+ ss));
				}
			}
			if (j > 0) {
				ss = j - 1;
				adjField = lab.get(tt + "_" + ss);
				agentchecker = -1;
				try {
					agentchecker = Integer.parseInt(adjField);
				} catch (Exception e) {
					
				}
				if (adjField.equalsIgnoreCase("A") || agentchecker > 0) {
					tmpKnowledge.put(tt + "_" + ss, " ");
					adjKnowledge = knowledge.get(adjField);
					if (null != adjKnowledge && !adjKnowledge.isEmpty())
						tmpKnowledge.putAll(adjKnowledge);
				} else {
					tmpKnowledge.put(tt + "_" + ss, lab.get(tt + "_"
							+ ss));
				}
			}
		}
		if (i > 0) {
			int tt = i - 1;
			int ss = j + 1;

			adjField = lab.get(tt + "_" + j);
			agentchecker = -1;
			try {
				agentchecker = Integer.parseInt(adjField);
			} catch (Exception e) {
				
			}
			if (adjField.equalsIgnoreCase("A") || agentchecker > 0) {
				tmpKnowledge.put(tt + "_" + j, " ");
				adjKnowledge = knowledge.get(adjField);
				if (null != adjKnowledge && !adjKnowledge.isEmpty())
					tmpKnowledge.putAll(adjKnowledge);
			} else {
				tmpKnowledge.put(tt + "_" + j, lab.get(tt + "_" + j));
			}

			if (j < columnsOfField - 1) {
				adjField = lab.get(tt + "_" + ss);
				agentchecker = -1;
				try {
					agentchecker = Integer.parseInt(adjField);
				} catch (Exception e) {
					// do nothing leave -1
				}
				if (adjField.equalsIgnoreCase("A") || agentchecker > 0) {
					tmpKnowledge.put(tt + "_" + ss, " ");
					adjKnowledge = knowledge.get(adjField);
					if (null != adjKnowledge && !adjKnowledge.isEmpty())
						tmpKnowledge.putAll(adjKnowledge);
				} else {
					tmpKnowledge.put(tt + "_" + ss, lab.get(tt + "_"
							+ ss));
				}
			}
			if (j > 0) {
				ss = j - 1;
				adjField = lab.get(tt + "_" + ss);
				agentchecker = -1;
				try {
					agentchecker = Integer.parseInt(adjField);
				} catch (Exception e) {
					
				}
				if (adjField.equalsIgnoreCase("A") || agentchecker > 0) {
					tmpKnowledge.put(tt + "_" + ss, " ");
					adjKnowledge = knowledge.get(adjField);
					if (null != adjKnowledge && !adjKnowledge.isEmpty())
						tmpKnowledge.putAll(adjKnowledge);
				} else {
					tmpKnowledge.put(tt + "_" + ss, lab.get(tt + "_"
							+ ss));
				}
			}
		}

		if (j < columnsOfField - 1) {
			int tt = i + 1;
			int ss = j + 1;
			adjField = lab.get(i + "_" + ss);
			agentchecker = -1;
			try {
				agentchecker = Integer.parseInt(adjField);
			} catch (Exception e) {
				// do nothing leave -1
			}
			if (adjField.equalsIgnoreCase("A") || agentchecker > 0) {
				tmpKnowledge.put(i + "_" + ss, " ");
				adjKnowledge = knowledge.get(adjField);
				if (null != adjKnowledge && !adjKnowledge.isEmpty())
					tmpKnowledge.putAll(adjKnowledge);
			} else {
				tmpKnowledge.put(i + "_" + ss, lab.get(i + "_" + ss));
			}
			if (i < linesOfField - 1) {
				adjField = lab.get(tt + "_" + ss);
				agentchecker = -1;
				try {
					agentchecker = Integer.parseInt(adjField);
				} catch (Exception e) {
					// do nothing leave -1
				}
				if (adjField.equalsIgnoreCase("A") || agentchecker > 0) {
					tmpKnowledge.put(tt + "_" + ss, " ");
					adjKnowledge = knowledge.get(adjField);
					if (null != adjKnowledge && !adjKnowledge.isEmpty())
						tmpKnowledge.putAll(adjKnowledge);
				} else {
					tmpKnowledge.put(tt + "_" + ss, lab.get(tt + "_"
							+ ss));
				}
			}
			if (i > 0) {
				tt = i - 1;
				adjField = lab.get(tt + "_" + ss);
				agentchecker = -1;
				try {
					agentchecker = Integer.parseInt(adjField);
				} catch (Exception e) {
					
				}
				if (adjField.equalsIgnoreCase("A") || agentchecker > 0) {
					tmpKnowledge.put(tt + "_" + ss, " ");
					adjKnowledge = knowledge.get(adjField);
					if (null != adjKnowledge && !adjKnowledge.isEmpty())
						tmpKnowledge.putAll(adjKnowledge);
				} else {
					tmpKnowledge.put(tt + "_" + ss, lab.get(tt + "_"
							+ ss));
				}
			}
		}
		if (j > 0) {
			int tt = i + 1;
			int ss = j - 1;

			adjField = lab.get(tt + "_" + j);
			agentchecker = -1;
			try {
				agentchecker = Integer.parseInt(adjField);
			} catch (Exception e) {
				
			}
			if (adjField.equalsIgnoreCase("A") || agentchecker > 0) {
				tmpKnowledge.put(tt + "_" + ss, " ");
				adjKnowledge = knowledge.get(adjField);
				if (null != adjKnowledge && !adjKnowledge.isEmpty())
					tmpKnowledge.putAll(adjKnowledge);
			} else {
				tmpKnowledge.put(tt + "_" + j, lab.get(tt + "_" + j));
			}
			tmpKnowledge.put(tt + "_" + j, lab.get(tt + "_" + j));
			if (i < linesOfField - 1) {
				adjField = lab.get(tt + "_" + ss);
				agentchecker = -1;
				try {
					agentchecker = Integer.parseInt(adjField);
				} catch (Exception e) {
					
				}
				if (adjField.equalsIgnoreCase("A") || agentchecker > 0) {
					tmpKnowledge.put(tt + "_" + ss, " ");
					adjKnowledge = knowledge.get(adjField);
					if (null != adjKnowledge && !adjKnowledge.isEmpty())
						tmpKnowledge.putAll(adjKnowledge);
				} else {
					tmpKnowledge.put(tt + "_" + ss, lab.get(tt + "_"
							+ ss));
				}
			}
			if (i > 0) {
				tt = i - 1;
				adjField = lab.get(tt + "_" + ss);
				agentchecker = -1;
				try {
					agentchecker = Integer.parseInt(adjField);
				} catch (Exception e) {
					// do nothing leave -1
				}
				if (adjField.equalsIgnoreCase("A") || agentchecker > 0) {
					tmpKnowledge.put(tt + "_" + ss, " ");
					adjKnowledge = knowledge.get(adjField);
					if (null != adjKnowledge && !adjKnowledge.isEmpty())
						tmpKnowledge.putAll(adjKnowledge);
				} else {
					tmpKnowledge.put(tt + "_" + ss, lab.get(tt + "_"
							+ ss));
				}
			}
		}

		knowledge.put(field, tmpKnowledge);
		return knowledge;
	}

	public static Hashtable<String, Hashtable> moveAgent(int i, int j,
			String agent, Hashtable<String, String> worldContent,
			Hashtable<String, Hashtable<String, String>> agentMovements) {
		String nextFieldUp = "";
		String nextFieldRight = "";
		String nextFieldDown = "";
		String nextFieldLeft = "";
		int upI = i - 1;
		int upJ = j;
		int rightI = i;
		int rightJ = j + 1;
		int downI = i + 1;
		int downJ = j;
		int leftI = i;
		int leftJ = j - 1;

		// movement of this cycle: old position is the key, new the value
		Hashtable<String, String> am = agentMovements.get(agent);
		if (am == null)
			am = new Hashtable<String, String>();

		nextFieldUp = worldContent.get(upI + "_" + upJ);
		nextFieldRight = worldContent.get(rightI + "_" + rightJ);
		nextFieldDown = worldContent.get(downI + "_" + downJ);
		nextFieldLeft = worldContent.get(leftI + "_" + leftJ);

		boolean upFieldOK = null != nextFieldUp
				&& (nextFieldUp.equalsIgnoreCase(" ") || nextFieldUp
						.equalsIgnoreCase("B"));
		boolean upOK = !am.containsValue(upI + "_" + upJ) && upFieldOK;

		boolean downFieldOK = null != nextFieldDown
				&& (nextFieldDown.equalsIgnoreCase(" ") || nextFieldDown
						.equalsIgnoreCase("B"));
		boolean downOK = !am.containsValue(downI + "_" + downJ) && downFieldOK;

		boolean leftFieldOK = null != nextFieldLeft
				&& (nextFieldLeft.equalsIgnoreCase(" ") || nextFieldLeft
						.equalsIgnoreCase("B"));
		boolean leftOK = !am.containsValue(leftI + "_" + leftJ) && leftFieldOK;

		boolean rightFieldOK = null != nextFieldRight
				&& (nextFieldRight.equalsIgnoreCase(" ") || nextFieldRight
						.equalsIgnoreCase("B"));
		boolean rightOK = !am.containsValue(rightI + "_" + rightJ)
				&& rightFieldOK;

		boolean foundNewPos = false;

		int loopout = 0;
		int nextPosIndicator = -1;

		int availableStrictPos = 0;
		if (upOK)
			availableStrictPos++;
		if (rightOK)
			availableStrictPos++;
		if (downOK)
			availableStrictPos++;
		if (leftOK)
			availableStrictPos++;

		if (availableStrictPos == 0)
			nextPosIndicator = randomizer.nextInt(4);
		else if (availableStrictPos == 1) {
			if (upOK)
				nextPosIndicator = 0;
			else if (rightOK)
				nextPosIndicator = 1;
			else if (downOK)
				nextPosIndicator = 2;
			else if (leftOK)
				nextPosIndicator = 3;
		} else if (availableStrictPos == 2 || availableStrictPos == 3) {
			int cc = 0;
			int pseudorandom = randomizer.nextInt(availableStrictPos);
			while (cc < availableStrictPos) {
				cc++;
				if (upOK && cc == availableStrictPos) {
					nextPosIndicator = 0;
				} else if (rightOK && cc == availableStrictPos) {
					nextPosIndicator = 1;
				} else if (downOK && cc == availableStrictPos) {
					nextPosIndicator = 2;
				} else if (leftOK && cc == availableStrictPos) {
					nextPosIndicator = 3;
				}
			}

		} else {
			nextPosIndicator = randomizer.nextInt(availableStrictPos);
		}

		while (!foundNewPos && loopout < 101) {
			loopout++;

			switch (nextPosIndicator) {
			case 0:
				if (upFieldOK) {
					if (nextFieldUp.equalsIgnoreCase("B")
							&& !agent.equalsIgnoreCase("A")) {
						
						foundNewPos = true;
					} else {
						worldContent.put(i + "_" + j, " ");
						worldContent.put(upI + "_" + upJ, agent);
						foundNewPos = true;
						am.put(i + "_" + j, upI + "_" + upJ);
					}
				}
				break;
			case 1:
				if (rightFieldOK) {
					if (nextFieldRight.equalsIgnoreCase("B")
							&& !agent.equalsIgnoreCase("A")) {
						
						foundNewPos = true;
					} else {
						worldContent.put(i + "_" + j, " ");
						worldContent.put(rightI + "_" + rightJ, agent);
						foundNewPos = true;
						am.put(i + "_" + j, rightI + "_" + rightJ);
					}
				}
				break;
			case 2:
				if (downFieldOK) {
					if (nextFieldDown.equalsIgnoreCase("B")
							&& !agent.equalsIgnoreCase("A")) {
						
						foundNewPos = true;
					} else {
						worldContent.put(i + "_" + j, " ");
						worldContent.put(downI + "_" + downJ, agent);
						foundNewPos = true;
						am.put(i + "_" + j, downI + "_" + downJ);
					}

				}
				break;
			case 3:
				if (leftFieldOK) {
					if (nextFieldLeft.equalsIgnoreCase("B")
							&& !agent.equalsIgnoreCase("A")) {
						
						foundNewPos = true;
					} else {
						worldContent.put(i + "_" + j, " ");
						worldContent.put(leftI + "_" + leftJ, agent);
						foundNewPos = true;
						am.put(i + "_" + j, leftI + "_" + leftJ);
					}

				}
				break;
			default:

				break;
			}

			nextPosIndicator = randomizer.nextInt(4);
		}

		agentMovements.put(agent, am);

		Hashtable<String, Hashtable> ret = new Hashtable<String, Hashtable>();
		ret.put("kosmos", worldContent);
		ret.put("kinhseis", agentMovements);

		return ret;
	}

	public static Hashtable<String, Hashtable> praktorasToDiffuser(int i,
			int j, int mechX, int mechY, String field,
			Hashtable<String, String> worldContent,
			Hashtable<String, Hashtable<String, String>> agentMovements) {
		int upI = i - 1;
		int upJ = j;
		int rightI = i;
		int rightJ = j + 1;
		int downI = i + 1;
		int downJ = j;
		int leftI = i;
		int leftJ = j - 1;

		String nextFieldUp = worldContent.get(upI + "_" + upJ);
		String nextFieldRight = worldContent.get(rightI + "_" + rightJ);
		String nextFieldDown = worldContent.get(downI + "_" + downJ);
		String nextFieldLeft = worldContent.get(leftI + "_" + leftJ);

		boolean upFieldOK = null != nextFieldUp
				&& (nextFieldUp.equalsIgnoreCase(" ") || nextFieldUp
						.equalsIgnoreCase("B"));
		boolean downFieldOK = null != nextFieldDown
				&& (nextFieldDown.equalsIgnoreCase(" ") || nextFieldDown
						.equalsIgnoreCase("B"));
		boolean leftFieldOK = null != nextFieldLeft
				&& (nextFieldLeft.equalsIgnoreCase(" ") || nextFieldLeft
						.equalsIgnoreCase("B"));
		boolean rightFieldOK = null != nextFieldRight
				&& (nextFieldRight.equalsIgnoreCase(" ") || nextFieldRight
						.equalsIgnoreCase("B"));

		int newX = 0;
		int newY = 0;
		if (mechX > i) {
			if (downFieldOK) {
				newX = downI;
				newY = downJ;
			} else if (rightFieldOK) {
				newX = rightI;
				newY = rightJ;
			} else if (leftFieldOK) {
				newX = leftI;
				newY = leftJ;
			} else {
				newX = upI;
				newY = upJ;
			}
		} else if (mechX < i) {
			if (upFieldOK) {
				newX = upI;
				newY = upJ;
			} else if (rightFieldOK) {
				newX = rightI;
				newY = rightJ;
			} else if (leftFieldOK) {
				newX = leftI;
				newY = leftJ;
			} else {
				newX = downI;
				newY = downJ;
			}
		} else {
			if (mechY > j) {
				if (rightFieldOK) {
					newX = rightI;
					newY = rightJ;
				} else if (upFieldOK) {
					newX = upI;
					newY = upJ;
				} else if (downFieldOK) {
					newX = downI;
					newY = downJ;
				} else {
					newX = leftI;
					newY = leftJ;
				}
			} else {
				if (leftFieldOK) {
					newX = leftI;
					newY = leftJ;
				} else if (upFieldOK) {
					newX = upI;
					newY = upJ;
				} else if (downFieldOK) {
					newX = downI;
					newY = downJ;
				} else {
					newX = rightI;
					newY = rightJ;
				}
			}
		}

		Hashtable<String, String> am = agentMovements.get(field);
		int counter = 0;
		if (am != null && !am.isEmpty()) {
			Iterator<String> amit = am.keySet().iterator();
			String test = "";
			while (amit.hasNext()) {
				test = amit.next();
				if (test.equalsIgnoreCase(newX + "_" + newY)) {
					counter++;
				}
			}
		}

		if (counter > 10) {
			
			return moveAgent(i, j, field, worldContent, agentMovements);
		} else {
			worldContent.put(i + "_" + j, " ");
			worldContent.put(newX + "_" + newY, field);
			am.put(i + "_" + j, newX + "_" + newY);
			agentMovements.put(field, am);

			Hashtable<String, Hashtable> ret = new Hashtable<String, Hashtable>();
			ret.put("kosmos", worldContent);
			ret.put("kinhseis", agentMovements);
			return ret;
		}
	}

	public static Hashtable<String, Hashtable> diffuserToBomb(int i, int j,
			int bombX, int bombY, String field,
			Hashtable<String, String> worldContent,
			Hashtable<String, Hashtable<String, String>> agentMovements) {
		int upI = i - 1;
		int upJ = j;
		int rightI = i;
		int rightJ = j + 1;
		int downI = i + 1;
		int downJ = j;
		int leftI = i;
		int leftJ = j - 1;

		String nextFieldUp = worldContent.get(upI + "_" + upJ);
		String nextFieldRight = worldContent.get(rightI + "_" + rightJ);
		String nextFieldDown = worldContent.get(downI + "_" + downJ);
		String nextFieldLeft = worldContent.get(leftI + "_" + leftJ);

		boolean upFieldOK = null != nextFieldUp
				&& (nextFieldUp.equalsIgnoreCase(" ") || nextFieldUp
						.equalsIgnoreCase("B"));
		boolean downFieldOK = null != nextFieldDown
				&& (nextFieldDown.equalsIgnoreCase(" ") || nextFieldDown
						.equalsIgnoreCase("B"));
		boolean leftFieldOK = null != nextFieldLeft
				&& (nextFieldLeft.equalsIgnoreCase(" ") || nextFieldLeft
						.equalsIgnoreCase("B"));
		boolean rightFieldOK = null != nextFieldRight
				&& (nextFieldRight.equalsIgnoreCase(" ") || nextFieldRight
						.equalsIgnoreCase("B"));

		int newX = 0;
		int newY = 0;
		if (bombX > i) {
			if (downFieldOK) {
				newX = downI;
				newY = downJ;
			} else if (rightFieldOK) {
				newX = rightI;
				newY = rightJ;
			} else if (leftFieldOK) {
				newX = leftI;
				newY = leftJ;
			} else {
				newX = upI;
				newY = upJ;
			}
		} else if (bombX < i) {
			if (upFieldOK) {
				newX = upI;
				newY = upJ;
			} else if (rightFieldOK) {
				newX = rightI;
				newY = rightJ;
			} else if (leftFieldOK) {
				newX = leftI;
				newY = leftJ;
			} else {
				newX = downI;
				newY = downJ;
			}
		} else {
			if (bombY > j) {
				if (rightFieldOK) {
					newX = rightI;
					newY = rightJ;
				} else if (upFieldOK) {
					newX = upI;
					newY = upJ;
				} else if (downFieldOK) {
					newX = downI;
					newY = downJ;
				} else {
					newX = leftI;
					newY = leftJ;
				}
			} else {
				if (leftFieldOK) {
					newX = leftI;
					newY = leftJ;
				} else if (upFieldOK) {
					newX = upI;
					newY = upJ;
				} else if (downFieldOK) {
					newX = downI;
					newY = downJ;
				} else {
					newX = rightI;
					newY = rightJ;
				}
			}
		}

		Hashtable<String, String> am = agentMovements.get(field);
		int counter = 0;
		if (am != null && !am.isEmpty()) {
			Iterator<String> amit = am.keySet().iterator();
			String test = "";
			while (amit.hasNext()) {
				test = amit.next();
				if (test.equalsIgnoreCase(newX + "_" + newY)) {
					counter++;
				}
			}
		}

		if (counter > 10) {
			
			return moveAgent(i, j, field, worldContent, agentMovements);
		} else {
			worldContent.put(i + "_" + j, " ");
			worldContent.put(newX + "_" + newY, field);
			am.put(i + "_" + j, newX + "_" + newY);
			agentMovements.put(field, am);

			Hashtable<String, Hashtable> ret = new Hashtable<String, Hashtable>();
			ret.put("world", worldContent);
			ret.put("moves", agentMovements);
			return ret;
		}

	}

}
