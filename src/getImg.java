    /**
     * author: Zeuc
     * date: 2017-07-19
     * function: 查看签名图片
     *
     * @param imgFile 图片文件名
     * @return
     */
    @RequestMapping(value = "/getImg/{imgFile}")
    @ResponseBody
    public void getImg(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable("imgFile") String imgFile) throws IOException {
        response.setContentType("image/*");
        ResponseBean result=new ResponseBean();
        FileInputStream fis=null;
        OutputStream os=null;
        String filePath = "/home/signimg/user/";//指定上传后路径
        String tempFilePath = "E:/img/";

        try {
            fis=new FileInputStream(tempFilePath+imgFile+".png");
            System.out.println();
//            result.setMessage("获取图片成功");
//            result.setCode(0);
//            result.setSuccess(true);
//            result.setData(null);
        } catch (FileNotFoundException e) {
//            result.setMessage("找不到图片");
//            result.setCode(1);
//            result.setSuccess(false);
//            result.setData(null);
            e.printStackTrace();
        }
        int count= fis.available();
        byte[] buffer=new byte[count];
        fis.read(buffer);
        os=response.getOutputStream();
        os.write(buffer);
        os.flush();
        os.close();
        fis.close();
    }