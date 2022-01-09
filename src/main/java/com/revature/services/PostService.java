package com.revature.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.revature.DAOs.PostDao;
import com.revature.models.Post;

@Service
public class PostService {
	private PostDao pd;
	
	public PostService(PostDao pd) {
		this.pd = pd;
	}	
	
	public Post createPost(Post p, String username) {
		p.setUsername(username);
		p.setCreationDate(new Date());		
		return pd.save(p);
	}
	
	public Post createPostWithFile(Post p, String username, MultipartFile file) throws IOException {
		p.setUsername(username);
		p.setCreationDate(new Date());	
		if (file!= null) {
		saveImage(p, file);};
		return pd.save(p);
	
	}

	public List<Post> getTopLevelPosts() throws IOException {		
		S3Service s3 = new S3Service();
		for (Post post : pd.findByParentIdIsNull()) {
			//uuid is a unique identifier for the file
			if (post.getUuid()!= null) {
				post.setImage(s3.getSignedUrl(post.getUuid()));
				pd.save(post);
			}
		}
		return pd.findByParentIdIsNull();
	}
	
	public void saveImage(Post p, MultipartFile file) throws IOException {
		S3Service s3 = new S3Service();
		try {
			p.setUuid(s3.upload(file));	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
