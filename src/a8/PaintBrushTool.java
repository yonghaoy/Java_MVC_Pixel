package a8;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintBrushTool implements Tool{

	private PaintBrushToolUI ui;
	private ImageEditorModel model;	
	
	public PaintBrushTool(ImageEditorModel model) {
		this.model = model;
		ui = new PaintBrushToolUI();
	}
	
	public void set_inspect_pixel(Pixel p){
		ui.set_ini_panel(p);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//model.add_frame();
		
		model.paintAt(e.getX(), e.getY(), ui.getBrushColor(), ui.getBrushSize());
		//model.add_frame();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//model.add_frame();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		model.paintAt(e.getX(), e.getY(), ui.getBrushColor(), ui.getBrushSize());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Paint Brush";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}

//	@Override
//	public void stateChanged(ChangeEvent e) {
//		// TODO Auto-generated method stub
//		brush_size = 
//	}

}
