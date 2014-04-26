package a8;

import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageEditorView extends JPanel {

	private JFrame main_frame;
	private FrameView frame_view;
	private ImageEditorModel model;
	private ToolChooserWidget chooser_widget;
	private JPanel tool_ui_panel;
	private JPanel tool_ui;
	private JButton undo;
	
	public ImageEditorView(JFrame main_frame, ImageEditorModel model) {
		this.main_frame = main_frame;
		
		setLayout(new BorderLayout());
		
		frame_view = new FrameView(model.getCurrent());
		
		add(frame_view, BorderLayout.NORTH);
		
		tool_ui_panel = new JPanel();
		tool_ui_panel.setLayout(new BorderLayout());
		
		chooser_widget = new ToolChooserWidget();
		tool_ui_panel.add(chooser_widget, BorderLayout.NORTH);
		add(tool_ui_panel, BorderLayout.CENTER);
		
		tool_ui = null;
		undo = new JButton("undo");
		undo.setActionCommand("undo");
		//undo.addActionListener(undo_rensponder);
		add(undo,BorderLayout.SOUTH);
	}

	public void addToolChoiceListener(ToolChoiceListener l) {
		chooser_widget.addToolChoiceListener(l);
	}
	
	public String getCurrentToolName() {
		return chooser_widget.getCurrentToolName();
	}

	public void installToolUI(JPanel ui) {
		if (tool_ui != null) {
			tool_ui_panel.remove(tool_ui);
		}
		tool_ui = ui;
		tool_ui_panel.add(tool_ui);
		validate();
		main_frame.pack();
	}
	
	@Override
	public void addMouseMotionListener(MouseMotionListener l) {
		frame_view.addMouseMotionListener(l);
	}
	
	@Override
	public void removeMouseMotionListener(MouseMotionListener l) {
		frame_view.removeMouseMotionListener(l);
	}

	@Override
	public void addMouseListener(MouseListener l) {
		frame_view.addMouseListener(l);
	}
	
	public void removeMouseListener(MouseListener l) {
		frame_view.removeMouseListener(l);
	}
	public void addActionListener(ActionListener l){
		undo.addActionListener(l);
		
	}
	/*public void setView(Frame f){
		frame_view = new FrameView(f);
		add(frame_view, BorderLayout.NORTH);
	}*/

}
