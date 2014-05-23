package com.util;


public class Upload {
// 
//    public boolean anexos(HttpServletRequest request, HttpServletResponse response) throws Exception {
// 
//	if (ServletFileUpload.isMultipartContent(request)) {
// 
//		int cont = 0;
// 
//		ServletFileUpload servletFileUpload = new ServletFileUpload(
//					new DiskFileItemFactory());
// 
//		List fileItemsList = null;
// 
//		try {
//			fileItemsList = servletFileUpload.parseRequest(request);
//		} catch (FileUploadException e1) {
//			e1.printStackTrace();
//		}
// 
//		String optionalFileName = "";
//		FileItem fileItem = null;
// 
//		Iterator it = fileItemsList.iterator();
// 
//		do {
// 
//			cont++;
// 
//			FileItem fileItemTemp = (FileItem) it.next();
// 
//			if (fileItemTemp.isFormField()) {
//				if (fileItemTemp.getFieldName().equals("filename")) {
//					optionalFileName = fileItemTemp.getString();
//				}
//			} else {
//				fileItem = fileItemTemp;
//			}
// 
//			if (cont != (fileItemsList.size())) {
//				if (fileItem != null) {
// 
//					String fileName = fileItem.getName();
// 
//					if (fileItem.getSize() > 0) {
// 
//						if (optionalFileName.trim().equals("")) {
//							fileName = FilenameUtils.getName(fileName);
//						} else {
//							fileName = optionalFileName;
//						}
// 
//						String dirName = "/WORKSPACES/workspace-jee/ExemploUpload/WebContent/uploads/"; //caminho para o projeto
// 
//						File saveTo = new File(dirName + fileName);
// 
//						try {
//							fileItem.write(saveTo);
//						} catch (Exception e) {
// 
//						}
// 
//					}
//				}
//			}
//		} while (it.hasNext());
//		return true;
//	} else {
//		return false;
//	}
//    }
}