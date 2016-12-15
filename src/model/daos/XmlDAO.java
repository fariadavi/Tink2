package model.daos;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.tiposArquivo;

public abstract class XmlDAO<T> {
	
	private ArrayList<T> entryList;
	private final String PATH;
	
	public XmlDAO(tiposArquivo tipo) {
		this.PATH = tipo.getFilepath();
	}
	
	public abstract void addEntry(T newEntry);
	
	public T getEntry(int id) {		
		return id <= getList().size() ? getList().get(id-1) : null;
	}
	
	public ArrayList<T> getList() {
		if (entryList == null)
			readXML();
		
		return entryList;
	}
	
	public ArrayList<T> refreshList() {
		readXML();
		return entryList;
	}
	
	protected void writeXML(List<T> cadastros) {
		try {
			XMLEncoder encoder = null;
			try {
				encoder = new XMLEncoder(new FileOutputStream(PATH));
				encoder.writeObject(cadastros);
			} finally {
				if (encoder != null)
					encoder.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void readXML() {
		File file = new File(PATH);
		
		if (file.isFile()) {
			try {
				XMLDecoder decoder = null;
				try {
					decoder = new XMLDecoder(new FileInputStream(PATH));

					entryList = (ArrayList<T>) decoder.readObject();
				} finally {
					if (decoder != null)
						decoder.close();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			entryList = new ArrayList<T>();
		}
	}
}
