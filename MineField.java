package com.mine.sweeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import javax.swing.ImageIcon;



public class MineField extends JFrame implements Runnable {

	public Thread executionThread = null;
	public boolean paused = false;
	
	public File worldFile;
	
	public int rows;
	public int columns;
	public Hashtable<String, String> labMap = new Hashtable<String, String>();
	public Hashtable<String, JLabel> labGUI = new Hashtable<String, JLabel>();
	public Hashtable<String, Hashtable<String, String>> overallKnowledge =new Hashtable<String, Hashtable<String, String>>();
	public Hashtable<String, Hashtable<String, String>> moves =new Hashtable<String, Hashtable<String, String>>();
	
	

	public boolean diffuserKnows = false;
	public String mineAgent = null;
	public boolean foundMine = false;
	public int xMine = -1;
	public int yMine = -1;
	public int xDiffuser = -1;
	public int yDiffuser = -1;
	
	public JLabel jLabel0;
	public JButton startAlgorithm;
	public JButton stopAlgorithm;
	public JButton cancelAlgorithm;
	public JTextField jTextField0;
	public JButton loadFieldFile;
	public JLabel jLabel1;
	public JButton showField;
	public JLabel point0_0;
	public JLabel dan;
	public JLabel message;
	public JButton showDiffuser;
	public JButton showHide1;
	public JButton showHide2;
	public JButton showHide3;
	public JButton showHide4;
	public JButton showHide5;
	public JButton showHide6;
	public JButton showHide7;
	public JButton showHide8;
	public JButton showHide9;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public MineField() {
		getContentPane().setBackground(Color.GRAY);
		initComponents();
		
		message.setVisible(false);
		startAlgorithm.setVisible(false);
		stopAlgorithm.setVisible(false);
		cancelAlgorithm.setVisible(false);
		point0_0.setVisible(false);
		showDiffuser.setVisible(false);
		showHide1.setVisible(false);
		showHide2.setVisible(false);
		showHide3.setVisible(false);
		showHide4.setVisible(false);
		showHide5.setVisible(false);
		showHide6.setVisible(false);
		showHide7.setVisible(false);
		showHide8.setVisible(false);
		showHide9.setVisible(false);
	}

	private void initComponents() {
		setTitle("MineSweeper");
		getContentPane().setLayout(new GroupLayout());
		getContentPane().add(getJLabel0(), new Constraints(new Leading(113, 797, 10, 10), new Leading(23, 25, 10, 10)));
		getContentPane().add(getStartButton(), new Constraints(new Leading(810, 10, 10), new Leading(45, 6, 6)));
		getContentPane().add(getPauseButton(), new Constraints(new Leading(806, 6, 6), new Leading(83, 6, 6)));
		getContentPane().add(getCancelButton(), new Constraints(new Leading(805, 6, 6), new Leading(124, 10, 10)));
		getContentPane().add(getpoint0_0(), new Constraints(new Leading(213, 28, 6, 6), new Leading(214, 25, 10, 10)));
		getContentPane().add(getEndMessage(), new Constraints(new Leading(673, 340, 10, 10), new Leading(313, 66, 10, 10)));
		getContentPane().add(getShowDiffuser(), new Constraints(new Leading(49, 133, 10, 10), new Leading(196, 10, 10)));
		getContentPane().add(getShowHide1(), new Constraints(new Leading(58, 114, 6, 6), new Leading(226, 10, 10)));
		getContentPane().add(getShowHide2(), new Constraints(new Leading(58, 114, 6, 6), new Leading(257, 6, 6)));
		getContentPane().add(getShowHide3(), new Constraints(new Leading(58, 114, 6, 6), new Leading(287, 6, 6)));
		getContentPane().add(getShowHide4(), new Constraints(new Leading(58, 114, 6, 6), new Leading(317, 6, 6)));
		getContentPane().add(getShowHide5(), new Constraints(new Leading(58, 114, 6, 6), new Leading(347, 6, 6)));
		getContentPane().add(getShowHide6(), new Constraints(new Leading(58, 114, 6, 6), new Leading(377, 6, 6)));
		getContentPane().add(getShowHide7(), new Constraints(new Leading(58, 114, 6, 6), new Leading(407, 6, 6)));
		getContentPane().add(getShowHide8(), new Constraints(new Leading(58, 114, 6, 6), new Leading(437, 6, 6)));
		getContentPane().add(getShowHide9(), new Constraints(new Leading(58, 114, 6, 6), new Leading(467, 6, 6)));
		getContentPane().add(getJLabel1(), new Constraints(new Leading(164, 202, 10, 10), new Leading(118, 20, 12, 12)));
		getContentPane().add(getJTextField0(), new Constraints(new Leading(387, 288, 10, 10), new Leading(121, 12, 12)));
		getContentPane().add(getFileSearchButton(), new Constraints(new Leading(678, 10, 10), new Leading(118, 12, 12)));
		getContentPane().add(getJButton0(), new Constraints(new Leading(741, 12, 12), new Leading(118, 12, 12)));
		setSize(1023, 499);
	}

	private JButton getShowDiffuser() {
		if (showDiffuser == null) {
			showDiffuser = new JButton();
			showDiffuser.setText("Diffuser");
			showDiffuser.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					mechanicButtonMouseMouseClicked(event);
				}
			});
		}
		return showDiffuser;
	}

	private JButton getShowHide1() {
		if (showHide1 == null) {
			showHide1 = new JButton();
			showHide1.setText("Agent 1");
			showHide1.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					agent1ButtonMouseMouseClicked(event);
				}
			});
		}
		return showHide1;
	}

	private JButton getShowHide2() {
		if (showHide2 == null) {
			showHide2 = new JButton();
			showHide2.setText("Agent 2");
			showHide2.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					agent2ButtonMouseMouseClicked(event);
				}
			});
		}
		return showHide2;
	}

	private JButton getShowHide3() {
		if (showHide3 == null) {
			showHide3 = new JButton();
			showHide3.setText("Agent 3");
			showHide3.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					agent3ButtonMouseMouseClicked(event);
				}
			});
		}
		return showHide3;
	}

	private JButton getShowHide4() {
		if (showHide4 == null) {
			showHide4 = new JButton();
			showHide4.setText("Agent 4");
			showHide4.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					agent4ButtonMouseMouseClicked(event);
				}
			});
		}
		return showHide4;
	}

	private JButton getShowHide5() {
		if (showHide5 == null) {
			showHide5 = new JButton();
			showHide5.setText("Agent 5");
			showHide5.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					agent5ButtonMouseMouseClicked(event);
				}
			});
		}
		return showHide5;
	}

	private JButton getShowHide6() {
		if (showHide6 == null) {
			showHide6 = new JButton();
			showHide6.setText("Agent 6");
			showHide6.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					agent6ButtonMouseMouseClicked(event);
				}
			});
		}
		return showHide6;
	}

	private JButton getShowHide7() {
		if (showHide7 == null) {
			showHide7 = new JButton();
			showHide7.setText("Agent 7");
			showHide7.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					agent7ButtonMouseMouseClicked(event);
				}
			});
		}
		return showHide7;
	}

	private JButton getShowHide8() {
		if (showHide8 == null) {
			showHide8 = new JButton();
			showHide8.setText("Agent 8");
			showHide8.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					agent8ButtonMouseMouseClicked(event);
				}
			});
		}
		return showHide8;
	}

	private JButton getShowHide9() {
		if (showHide9 == null) {
			showHide9 = new JButton();
			showHide9.setText("Agent 9");
			showHide9.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					agent9ButtonMouseMouseClicked(event);
				}
			});
		}
		return showHide9;
	}
	
		
		
	

	private JLabel getEndMessage() {
		if (message == null) {
			message = new JLabel();
			message.setBackground(Color.WHITE);
			message.setFont(new Font("Dialog", Font.BOLD, 24));
			message.setForeground(Color.ORANGE);
			message.setHorizontalAlignment(SwingConstants.CENTER);
			message.setText("THE END");
		}
		return message;
	}

	private JLabel getpoint0_0() {
		if (point0_0 == null) {
			point0_0 = new JLabel();
			point0_0.setBackground(Color.red);
			point0_0.setHorizontalAlignment(SwingConstants.CENTER);
			point0_0.setName("point0_0");
			point0_0.setText("*");
		}
		return point0_0;
	}

	private JButton getJButton0() {
		if (showField == null) {
			showField = new JButton();
			
			showField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			showField.setText("Load");
			showField.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					showWorldMouseMouseClicked(event);
				}
			});
		}
		return showField;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setFont(new Font("Dialog", Font.BOLD, 12));
			jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel1.setText("Labyrinth");
			jLabel1.setAutoscrolls(true);
		}
		return jLabel1;
	}

	private JButton getFileSearchButton() {
		if (loadFieldFile == null) {
			loadFieldFile = new JButton();
			loadFieldFile.setText("Find");
			loadFieldFile.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					fileSearchButtonMouseMouseClicked(event);
				}
			});
		}
		return loadFieldFile;
	}

	private JButton getCancelButton() {
		if (cancelAlgorithm == null) {
			cancelAlgorithm = new JButton();
			cancelAlgorithm.setText("Cancel");
			cancelAlgorithm.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					cancelButtonMouseMouseClicked(event);
				}
			});
		}
		return cancelAlgorithm;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
			jTextField0.setText("");
		}
		return jTextField0;
	}

	private JButton getStartButton() {
		if (startAlgorithm == null) {
			startAlgorithm = new JButton();
			startAlgorithm.setText("Start");
			startAlgorithm.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					startButtonMouseMouseClicked(event);
				}
			});
		}
		return startAlgorithm;
	}

	private JButton getPauseButton() {
		if (stopAlgorithm == null) {
			stopAlgorithm = new JButton();
			stopAlgorithm.setText("Pause");
			stopAlgorithm.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					pauseButtonMouseMouseClicked(event);
				}
			});
		}
		return stopAlgorithm;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setFont(new Font("Dialog", Font.BOLD, 16));
			jLabel0.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel0.setText("MineSweeper");
		}
		return jLabel0;
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MineField frame = new MineField();
				frame.setDefaultCloseOperation(MineField.EXIT_ON_CLOSE);
				frame.setTitle("MineSweeper");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	private void fileSearchButtonMouseMouseClicked(MouseEvent event) {
		
		jTextField0.setText("");
		resetAgentsAndWorld();
		
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(this);
		
		worldFile = null;
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			worldFile = jfc.getSelectedFile();
		}
		if (worldFile!=null)
			jTextField0.setText(worldFile.getAbsolutePath());
		
		
		showField.setVisible(true);
	}

	private void startButtonMouseMouseClicked(MouseEvent event) {
		
		if (executionThread==null) executionThread = new Thread(this);
		
		if (executionThread.isAlive()) {
			executionThread.interrupt();
		} 
		executionThread.start();
				
	}

	private void pauseButtonMouseMouseClicked(MouseEvent event) {
		
		pauseExecution();
		
	}
	
	private void pauseExecution() {
		try {
			
			paused = (paused) ? false : true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cancelButtonMouseMouseClicked(MouseEvent event) {
		
		Thread.currentThread().interrupt();
	}

	private void showWorldMouseMouseClicked(MouseEvent event) {
		if (worldFile!=null && worldFile.length()>0) {
			labMap = new Hashtable<String, String>();
			try {
				
				FileReader fr = new FileReader(worldFile);
				BufferedReader br = new BufferedReader(fr);
				
				rows = 0;
				columns = 0;
				String tmpField = null;
				String tmpLineCont = br.readLine();
				
				while (tmpLineCont != null){
					int tmpCol = 0;
					
					
					for (int i=0; i<tmpLineCont.length(); i++) {
						tmpField = Character.toString(tmpLineCont.charAt(i)); 
						
						if (tmpField!=null && tmpField.equalsIgnoreCase("B")) {
							xMine = rows;
							yMine = tmpCol;
						} 
						
						labMap.put(rows+"_"+tmpCol, tmpField);
						tmpCol++;
					}
					
					if (tmpCol>columns) columns=tmpCol;
					
					rows++;
					
					tmpLineCont = br.readLine();
				}
				
				br.close();
				fr.close();
			} catch (Exception exe) {
				exe.printStackTrace();
			}
			
			paintWorld(labMap);
	
			if (labMap.containsValue("1")) {
				showHide1.setVisible(true);
			} 
			if (labMap.containsValue("2")) {
				showHide2.setVisible(true);
			} 
			if (labMap.containsValue("3")) {
				showHide3.setVisible(true);
			} 
			if (labMap.containsValue("4")) {
				showHide4.setVisible(true);
			} 
			if (labMap.containsValue("5")) {
				showHide5.setVisible(true);
			} 
			if (labMap.containsValue("6")) {
				showHide6.setVisible(true);
			} 
			if (labMap.containsValue("7")) {
				showHide7.setVisible(true);
			} 
			if (labMap.containsValue("8")) {
				showHide8.setVisible(true);
			} 
			if (labMap.containsValue("9")) {
				showHide9.setVisible(true);
			}
			showDiffuser.setVisible(true);
			startAlgorithm.setVisible(true);
			stopAlgorithm.setVisible(true);
			cancelAlgorithm.setVisible(true);
		} else {
			jTextField0.setText("Choose Labyrinth File");
		}
	}
	
	public void paintWorld(Hashtable<String, String> worldContent) {
		
		try {
			Iterator<String> it = labGUI.keySet().iterator();
				
			String key = "";
			JLabel tmpLabel = null;
			while (it.hasNext()) {
				key = it.next();
				tmpLabel = labGUI.get(key);
				if (tmpLabel!=null) {
					tmpLabel.setText("");
					tmpLabel.repaint();
				}
			}
			
			String tmpField="";
			for (int i=0; i<rows; i++) {
				for (int j=0; j<columns; j++) {
					tmpField = worldContent.get(i+"_"+j);
					if (!labGUI.containsKey(i+"_"+j)) {
						if (null!=tmpField && tmpField.length()>0) {
							JLabel newJL = new JLabel();
							newJL.setHorizontalAlignment(SwingConstants.CENTER);
							newJL.setName("shmeio"+i+"_"+j);
							newJL.setText(tmpField);
							
							if (i==0 && j==0) {
								point0_0.setText(tmpField);
								point0_0.setVisible(true);
								labGUI.put(i+"_"+j, point0_0);
							} else {
								this.getContentPane().add(newJL, new Constraints(new Leading(point0_0.getX()+point0_0.getWidth()*j, 28, 10, 10), 
										new Leading(point0_0.getY()+point0_0.getHeight()*i, 25, 10, 10)));
								
								labGUI.put(i+"_"+j, newJL);
							}
						}
					} else {
						JLabel tmplabel = labGUI.get(i+"_"+j);
						tmplabel.setText(tmpField);
						tmpLabel.repaint();
					}
				}
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}
	
	private void resetAgentsAndWorld() {
		labMap = null;
		overallKnowledge = null;
		Set kset = (labGUI.keySet()!=null) ? labGUI.keySet() : new Hashtable().keySet();
		Iterator<String> kit = kset.iterator();
		
		String key = null;
		JLabel tmp = null;
		while (kit.hasNext()) {
			key = kit.next();
			tmp = labGUI.get(key);
			if (tmp!=null) tmp.setText("");
		}
		
		if (executionThread!=null) executionThread=null;
		moves =new Hashtable<String, Hashtable<String, String>>();
		
		diffuserKnows = false;
		mineAgent = null;
		foundMine = false;
		
		startAlgorithm.setVisible(false);
		stopAlgorithm.setVisible(false);
		cancelAlgorithm.setVisible(false);
		message.setVisible(false);
		
	}
	
	public void run() {
		
		startAlgorithm.setVisible(false);
		try {
			int cycles = 0;
			long start = System.currentTimeMillis();
			while (!foundMine) {
				cycles++;
				while (paused) Thread.currentThread().sleep(100);
				
				labMap = epomenhKinhsh(this.labMap);
				
				paintWorld(labMap);
				Thread.currentThread().sleep(100);
			}
			long end = System.currentTimeMillis();
			
			message.setVisible(true);

				
		} catch (Exception e) {
			e.printStackTrace();
		}
		startAlgorithm.setVisible(true);
	}
	
	private synchronized Hashtable<String, String> epomenhKinhsh(Hashtable<String, String> worldContent) {
		
		String field = "";
		Hashtable<String, String> agents = new Hashtable<String, String>();
		
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++) {
				field = worldContent.get(i+"_"+j);
				if (field.equalsIgnoreCase("*")) {
				
				} else if (field.equalsIgnoreCase(" ")) {
					
				} else if (field.equalsIgnoreCase("B")) {
					
				} else {
					int agentId = -1;
					try {
						agentId = Integer.parseInt(field);
					} catch (Exception e) {}

					if (agentId > 0 || field.equalsIgnoreCase("A")) {
						agents.put(field, i+"_"+j);						
					}
				}
			}
		}
		
		Iterator<String> keyIt = agents.keySet().iterator();
		String agent = null;
		while (keyIt.hasNext()) {
			agent = keyIt.next();
			String xy = agents.get(agent);
			String[] xyArr = xy.split("_");
			int x = Integer.parseInt(xyArr[0]);
			int y = Integer.parseInt(xyArr[1]);
			
			if (agent.equalsIgnoreCase("A")) {
				xDiffuser = x;
				yDiffuser = y;
			}
			
			if (!diffuserKnows || !agent.equalsIgnoreCase("A")) {
				
				if (mineAgent!=null && agent.equalsIgnoreCase(mineAgent)) {
					Hashtable<String, Hashtable> ret = Agent.praktorasToDiffuser(x, y, xDiffuser, yDiffuser, agent, worldContent, moves);
					worldContent = ret.get("kosmos");
					moves = ret.get("kinhseis");
					overallKnowledge = Agent.antallaghGnwshs(rows, columns, x, y, agent, worldContent, overallKnowledge);
				} else if (mineAgent==null || (mineAgent!=null && !agent.equalsIgnoreCase(mineAgent))) {
					Hashtable<String, Hashtable> ret = Agent.moveAgent(x,y,agent, worldContent, moves);
					worldContent = ret.get("kosmos");
					moves = ret.get("kinhseis");
					overallKnowledge = Agent.antallaghGnwshs(rows, columns, x, y, agent, worldContent, overallKnowledge);
				}
				
			} else if (agent.equalsIgnoreCase("A")) {
				Hashtable<String, Hashtable> ret = Agent.diffuserToBomb(x,y,xMine,yMine,agent, worldContent,moves);
				worldContent = ret.get("kosmos");
				moves = ret.get("kinhseis");
			}
			
			if (!worldContent.get(xMine+"_"+yMine).equalsIgnoreCase("B")) foundMine = true;
		}

		Iterator<String> keyit = overallKnowledge.keySet().iterator();
		String agentOrMechanic = null;
		Hashtable<String, String> tmpKnowledge = null;
		while (keyit.hasNext()) {
			agentOrMechanic = keyit.next();
			tmpKnowledge = overallKnowledge.get(agentOrMechanic);
			if (agentOrMechanic.equalsIgnoreCase("A"))
				this.diffuserKnows = (tmpKnowledge!=null && tmpKnowledge.containsValue("B")) ? true : false;
			this.mineAgent = (tmpKnowledge!=null && tmpKnowledge.containsValue("B")) ? agentOrMechanic : null;
		}
		
		
		
		return worldContent;
	}
	
	public void markKnownPlaces(String agentKey) {
		Hashtable<String, String> know = overallKnowledge.get(agentKey);
		if (null!=know && !know.isEmpty()) {
			Iterator<String> kit = know.keySet().iterator();
			while (kit.hasNext()) {
				String knownPosition = kit.next();
				JLabel knownJLabel = labGUI.get(knownPosition);
				knownJLabel.setBorder(LineBorder.createBlackLineBorder());
			}
		}
	}
	
	public void hideKnownPlaces(String agentKey) {
		Iterator<String> kit = labMap.keySet().iterator();
		while (kit.hasNext()) {
			String knownPosition = kit.next();
			JLabel knownJLabel = labGUI.get(knownPosition);
			knownJLabel.setBorder(null);
		}
	}

	private void mechanicButtonMouseMouseClicked(MouseEvent event) {
		pauseExecution();
		
		if (paused) {
			markKnownPlaces("A");
		} else {
			hideKnownPlaces("A");
		}
	}

	private void agent1ButtonMouseMouseClicked(MouseEvent event) {
		pauseExecution();

		if (paused) {
			markKnownPlaces("1");
		} else {
			hideKnownPlaces("1");
		}
	}

	private void agent2ButtonMouseMouseClicked(MouseEvent event) {
		pauseExecution();

		if (paused) {
			markKnownPlaces("2");
		} else {
			hideKnownPlaces("2");
		}
	}

	private void agent3ButtonMouseMouseClicked(MouseEvent event) {
		pauseExecution();

		if (paused) {
			markKnownPlaces("3");
		} else {
			hideKnownPlaces("3");
		}
	}

	private void agent4ButtonMouseMouseClicked(MouseEvent event) {
		pauseExecution();

		if (paused) {
			markKnownPlaces("4");
		} else {
			hideKnownPlaces("4");
		}
	}

	private void agent5ButtonMouseMouseClicked(MouseEvent event) {
		pauseExecution();

		if (paused) {
			markKnownPlaces("5");
		} else {
			hideKnownPlaces("5");
		}
	}

	private void agent6ButtonMouseMouseClicked(MouseEvent event) {
		pauseExecution();

		if (paused) {
			markKnownPlaces("6");
		} else {
			hideKnownPlaces("6");
		}
	}

	private void agent7ButtonMouseMouseClicked(MouseEvent event) {
		pauseExecution();

		if (paused) {
			markKnownPlaces("7");
		} else {
			hideKnownPlaces("7");
		}
	}

	private void agent8ButtonMouseMouseClicked(MouseEvent event) {
		pauseExecution();

		if (paused) {
			markKnownPlaces("8");
		} else {
			hideKnownPlaces("8");
		}
	}

	private void agent9ButtonMouseMouseClicked(MouseEvent event) {
		pauseExecution();

		if (paused) {
			markKnownPlaces("9");
		} else {
			hideKnownPlaces("9");
		}
	}
}
