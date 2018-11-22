//
//  WebViewController.swift
//  EmbeddedFontSample
//

import UIKit
import WebKit

class WebViewController: UIViewController {

    var url: String?

    @IBOutlet weak var webView: WKWebView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        guard let targetUrl = url else {
            return
        }
        
        print("targetUrl:", targetUrl)
        let myURL = URL(string: targetUrl)
        let myRequest = URLRequest(url: myURL!)
        webView.load(myRequest)
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
