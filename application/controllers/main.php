<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Main extends CI_Controller {

    function __construct()
    {
        parent::__construct();
        $this->load->model('Facebook_model');
    }
	/**
	 * Index Page for this controller.
	 *
	 * Maps to the following URL
	 * 		http://example.com/index.php/welcome
	 *	- or -  
	 * 		http://example.com/index.php/welcome/index
	 *	- or -
	 * Since this controller is set as the default controller in 
	 * config/routes.php, it's displayed at http://example.com/
	 *
	 * So any other public methods not prefixed with an underscore will
	 * map to /index.php/welcome/<method_name>
	 * @see http://codeigniter.com/user_guide/general/urls.html
	 */
	public function index()
	{
		$fb_data = $this->session->userdata('fb_data');
		 $data['content']['blocks'] = array('slider','banners','shops');
		 $data['fb_data'] = $fb_data;
		$this->load->view('home',$data);
	}
	
	function topsecret()
	{
		$fb_data = $this->session->userdata('fb_data');
		$this->load->helper('url'); 
		if((!$fb_data['uid']) or (!$fb_data['me']))
		{
			redirect('main');
		}
		else
		{
			$data = array(
						'fb_data' => $fb_data,
						);
			
			$this->load->view('topsecret', $data);
		}
	}
	
	
}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */