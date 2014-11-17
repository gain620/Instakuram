package upload;

import gui.UploadFrame;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class Uploader implements ImageObserver {
	private FileInputStream fis = null;
	private FileDialog fileDialog = null;
	
	public Uploader() {
		
	}
	
	public void upload() throws IOException {
		fileDialog = new FileDialog(new Frame(), "Select image file", FileDialog.LOAD);
		fileDialog.setDirectory("C:\\");
		fileDialog.setFilenameFilter(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".jpg"); // 추가 가능할듯
			}
		});
		
		fileDialog.setVisible(true);

		if(fileDialog.getFile() != null) {
			fis = new FileInputStream(fileDialog.getDirectory() + fileDialog.getFile());
			Image img = Toolkit.getDefaultToolkit().getImage(fileDialog.getDirectory() + fileDialog.getFile());
			
			UploadFrame uFrame = new UploadFrame(img);
			uFrame.setSize(img.getWidth(this), img.getHeight(this));
			uFrame.setVisible(true);
			
			fis.close();
		}
		else System.out.println("Upload canceled");
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
			int arg4, int arg5) {
		if (arg0 != null) return true;
		return false;
	}

}