				<div class="recommands">
					<div class="contentblock">
					<div class="comments_block">
						<div class="triangle add_comment_block"></div>
						<input type="text" name="addComment" value="כתוב תגובה">
						<div class="add_comment">הגב</div>
					</div>
					<ul class="store_recommand_list" id="commentsList">
					<?php foreach($comments as $comment) : ?>
					<?php $username = $this->users_model->getUserName($comment->user_id); ?>
						<li class="recommand_row">
							<div class="user_image"><img src="https://graph.facebook.com/<?php echo $comment->user_id ?>/picture"/></div>
							<div class="comment_bubble head_bubble">
								<div class="user_recommend">
									<div class="user_name bubble_user"><?php echo $username ?></div>
									<div class="text_recommand bubble_content"><?php echo $comment->contant ?></div>
								</div>
							</div>
							
						</li>
					<?php endforeach ?>	
					</ul>

					</div>
				</div>
				
<script type="text/javascript" charset="utf-8">
$(document).ready(function(){				
				
				
	var Input = $('input[name=addComment]');
	var default_value = Input.val();
	Input.focus(function() {
		if(Input.val() == default_value) Input.val("");
	}).blur(function(){
		// $('#divResult').hide();
		if(Input.val().length == 0) Input.val(default_value);
	}); 
 }); 
</script>