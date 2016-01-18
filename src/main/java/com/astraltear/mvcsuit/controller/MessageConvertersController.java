package com.astraltear.mvcsuit.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.astraltear.mvcsuit.domain.MessageConvertBean;
import com.rometools.rome.feed.atom.Feed;
import com.rometools.rome.feed.rss.Channel;

@Controller
@RequestMapping("/messageconverters")
public class MessageConvertersController {

	@RequestMapping(value="/string", method=RequestMethod.POST)
	@ResponseBody 
	public String readString(@RequestBody String string) {
		return "Read string '" + string + "'";
	}

	@RequestMapping(value="/string", method=RequestMethod.GET)
	@ResponseBody
	public  String writeString() {
		return "Wrote a string";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	@ResponseBody 
	public String readForm(@ModelAttribute MessageConvertBean messageConvertBean) {
		return "Read x-www-form-urlencoded: " + messageConvertBean;
	}
	

	@RequestMapping(value="/form", method=RequestMethod.GET)
	@ResponseBody 
	public MultiValueMap<String, String> writeForm() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("foo", "bar");
		map.add("fruit", "apple");
		return map;
	}
	

	@RequestMapping(value="/xml", method=RequestMethod.POST)
	@ResponseBody
	public  String readXml(@RequestBody MessageConvertBean messageConvertBean) {
		return "Read from XML: " + messageConvertBean;
	}
	

	@RequestMapping(value="/xml", method=RequestMethod.GET)
	@ResponseBody 
	public MessageConvertBean writeXml() {
		return new MessageConvertBean("bar", "apple");
	}
	

	@RequestMapping(value="/json", method=RequestMethod.POST)
	@ResponseBody 
	public String readJson(@Valid @RequestBody MessageConvertBean messageConvertBean) {
		return "Read from JSON: " + messageConvertBean;
	}

	@RequestMapping(value="/json", method=RequestMethod.GET)
	@ResponseBody 
	public MessageConvertBean writeJson() {
		return new MessageConvertBean("bar", "apple");
	}
	

	@RequestMapping(value="/atom", method=RequestMethod.POST)
	@ResponseBody
	public  String readFeed(@RequestBody Feed feed) {
		return "Read " + feed.getTitle();
	}

	@RequestMapping(value="/atom", method=RequestMethod.GET)
	@ResponseBody
	public  Feed writeFeed() {
		Feed feed = new Feed();
		feed.setFeedType("atom_1.0");
		feed.setTitle("My Atom feed");
		return feed;
	}

	@RequestMapping(value="/rss", method=RequestMethod.POST)
	@ResponseBody 
	public String readChannel(@RequestBody Channel channel) {
		return "Read " + channel.getTitle();
	}

	@RequestMapping(value="/rss", method=RequestMethod.GET)
	@ResponseBody 
	public Channel writeChannel() {
		Channel channel = new Channel();
		channel.setFeedType("rss_2.0");
		channel.setTitle("My RSS feed");
		channel.setDescription("Description");
		channel.setLink("http://localhost:8080/mvc-showcase/rss");
		return channel;
	}
}
