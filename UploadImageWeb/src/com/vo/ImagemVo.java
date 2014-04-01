package com.vo;

import javax.swing.ImageIcon;

import org.apache.commons.fileupload.FileItem;

public class ImagemVo {
	private Integer id;
	private FileItem fileItem;
	private ImageIcon image;
	private String nomeImagem;
	private byte[] imgArray;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FileItem getFileItem() {
		return fileItem;
	}

	public void setFileItem(FileItem fileItem) {
		this.fileItem = fileItem;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public byte[] getImgArray() {
		return imgArray;
	}

	public void setImgArray(byte[] imgArray) {
		this.imgArray = imgArray;
	}

}
