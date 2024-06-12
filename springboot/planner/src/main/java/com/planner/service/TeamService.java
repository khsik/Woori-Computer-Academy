package com.planner.service;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.planner.dto.TeamDTO;
import com.planner.mapper.TeamMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {

	private final TeamMapper teamMapper;
	private final String uploadPath = new File("").getAbsolutePath()+"\\src\\main\\resources\\static\\upload\\";
	
	public boolean teamNameOverlap(String team_name) {
		return teamMapper.teamNameOverlap(team_name) == 1 ? true : false;
	}
	
	public void teamCreate(String team_name, String team_explain, MultipartFile team_image) {
		TeamDTO dto = new TeamDTO();
		dto.setTeam_name(team_name);
		dto.setTeam_explain(team_explain);
		
		// 이미지 저장
		if(!team_image.isEmpty()) { // 업로드한 파일이 있고
			if(team_image.getContentType().startsWith("image")) { // 그게 이미지라면
				String imgName = team_image.getOriginalFilename(); // ext[ext.length-1] -> 확장자
				String ext = imgName.substring(imgName.lastIndexOf("."));
				String pathName = uploadPath + team_name + ext;
				// 이미지 리사이즈
				try {
					BufferedImage bufImg = ImageIO.read(team_image.getInputStream());
					BufferedImage reImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
					if(bufImg.getWidth() > 100 || bufImg.getHeight() > 100) { // 이미지 가로 세로가 100보다 크면
						Image resize = bufImg.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
						reImg.getGraphics().drawImage(resize, 0, 0, null);
						ImageIO.write(reImg, ext, new File(pathName));
					}else { // 이미지 가로 세로 둘다 100 이하면
						ImageIO.write(bufImg, ext, new File(pathName));
					}
				} catch (IOException e) {
					// return 타입 바꾸고 변수 미리 선언해둔 다음에, catch쪽에서 변수 값 변경하면
					// return 되는 값으로 이미지 저장 여부 확인 가능.
					e.printStackTrace();
				}
			}
		}
		
		teamMapper.teamInsert(dto);
	}
}
